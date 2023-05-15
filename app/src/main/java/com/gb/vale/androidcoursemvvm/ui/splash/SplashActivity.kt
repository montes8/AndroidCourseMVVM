package com.gb.vale.androidcoursemvvm.ui.splash

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.login.LoginActivity
import com.gb.vale.androidcoursemvvm.usecase.AppUseCase

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private var appUseCase : AppUseCase? = null
    private var viewModel : AppViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        //animaciones
        animation()
        appUseCase  = AppUseCase(this)
        viewModel = AppViewModel(appUseCase?:AppUseCase(this))


        Handler(Looper.getMainLooper()).postDelayed({
                viewModel?.validateLogin()
            },2000
        )


        //observador
        viewModel?.successSplash?.observe(this){
            if (it) HomeActivity.newInstance(this) else LoginActivity.newInstance(this)
            finish()
        }
    }
    private fun animation(){
        binding.lnBannerTop.animation = AnimationUtils.loadAnimation(this, R.anim.ani_top)
        binding.lnBannerBottom.animation = AnimationUtils.loadAnimation(this, R.anim.ani_bottom)

    }
}