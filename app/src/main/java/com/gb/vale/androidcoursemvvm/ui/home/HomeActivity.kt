package com.gb.vale.androidcoursemvvm.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.vale.androidcoursemvvm.repository.network.MovieModel
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.usecase.AppUseCase
import com.gb.vale.androidcoursemvvm.utils.dialogSimple
import com.gb.vale.androidcoursemvvm.utils.toastGeneric
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var appUseCase : AppUseCase? = null
    private var viewModel : AppViewModel? = null
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        lifecycle.addObserver(binding.youtubePlayerView)
        appUseCase  = AppUseCase(this)
        viewModel = AppViewModel(appUseCase?:AppUseCase(this))
        //simulamos cerrar sesion
        binding.imgTbLogout.setOnClickListener {
            dialogSimple{
                if (it){
                    viewModel?.logout()
                    finish()
                }}
        }

        viewModel?.loadMovie()

        viewModel?.successMovie?.observe(this){
            it?.let {
                loadMovie(it)
            }?:toastGeneric("Ocurrio un error en la peticion")
        }

    }

    @SuppressLint("KotlinNullnessAnnotation")
    private fun loadMovie(movie : MovieModel){
        binding.textTitleBannerOne.text = movie.title
        binding.textTitleBannerTwo.text = movie.description
        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady( @NonNull youTubePlayer: YouTubePlayer) {
                val videoId = movie.idMovie
                videoId?.let { youTubePlayer.loadVideo(it, 0f) }
            }
        })
    }
}