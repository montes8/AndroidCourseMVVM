package com.gb.`val`.androidcoursemvvm.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.gb.`val`.androidcoursemvvm.R
import com.gb.`val`.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.`val`.androidcoursemvvm.ui.HomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    private val viewModel : AppViewModel = AppViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        binding.lnBannerTop.animation = AnimationUtils.loadAnimation(this, R.anim.ani_top)
        binding.lnBannerBottom.animation = AnimationUtils.loadAnimation(this, R.anim.ani_bottom)


        viewModel.loadHome()

        viewModel.successSplash.observe(this){
            if (it) HomeActivity.newIntance(this)
        }
    }
}