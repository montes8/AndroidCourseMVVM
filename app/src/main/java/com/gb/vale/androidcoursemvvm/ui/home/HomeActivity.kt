package com.gb.vale.androidcoursemvvm.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.vale.androidcoursemvvm.ui.network.ACMService
import com.gb.vale.androidcoursemvvm.ui.network.MovieModel
import com.gb.vale.androidcoursemvvm.ui.utils.dialogSimple
import com.gb.vale.androidcoursemvvm.ui.utils.toastGeneric
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var shared : SharedPreferences? = null
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        lifecycle.addObserver(binding.youtubePlayerView)

        //inicializamos el sharedPreference
        shared = getSharedPreferences("myPreference", MODE_PRIVATE)

        //simulamos cerrar sesion
        binding.imgTbLogout.setOnClickListener {
            dialogSimple{
                if (it){
                    shared?.edit()?.putBoolean("token",false)?.apply()
                    finish()
                }
            }

        }


        val loadMovieCall = ACMService.create().loadMovie()
        loadMovieCall.enqueue(object : Callback<MovieModel?>{
            override fun onResponse(call: Call<MovieModel?>, response: Response<MovieModel?>) {
                if (response.code() == 200){
                    val movie = response.body()
                    if (movie != null){
                            loadMovie(movie.idMovie)
                        binding.textTitleBannerOne.text = movie.title
                        binding.textTitleBannerTwo.text = movie.description
                        toastGeneric(movie.toString())
                    }else{
                        toastGeneric("El dato no se pudo parsear")
                    }

                }else{
                    toastGeneric("Ocurrio un error en la peticion")
                }

            }

            override fun onFailure(call: Call<MovieModel?>, t: Throwable) {
                toastGeneric("Ocurrio un error desconocido en la peticion")
            }

        })



    }

    fun loadMovie(id : String?){
        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = id
                videoId?.let { youTubePlayer.loadVideo(it, 0f) }
            }
        })
    }

}