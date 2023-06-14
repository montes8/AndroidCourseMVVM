package com.gb.vale.androidcoursemvvm.ui.home

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.vale.androidcoursemvvm.model.MovieModel
import com.gb.vale.androidcoursemvvm.ui.BaseActivity
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.ui.splash.AppViewModel
import com.gb.vale.androidcoursemvvm.utils.toastGeneric
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: AppViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()


    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        lifecycle.addObserver(binding.youtubePlayerView)
        binding.imgTbLogout.setOnClickListener {
            viewModel.logout()
            finish()
        }

        homeViewModel.loadMovie()
    }

    override fun observerViewModel() {
        homeViewModel.successMovie.observe(this){
            it?.let {
                configMovie(it)
            }?:toastGeneric("Ocurrio un error en la peticion")
        }
    }

    private fun configMovie(data : MovieModel){
        binding.textTitleBannerOne.text = data.title
        binding.textTitleBannerTwo.text = data.description
        binding.youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(data.idMovie,0f)
            }
        })
    }


    override fun getViewModel(): BaseViewModel? = null

}