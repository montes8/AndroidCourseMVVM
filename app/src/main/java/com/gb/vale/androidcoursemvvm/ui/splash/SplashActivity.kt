package com.gb.vale.androidcoursemvvm.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(),ISplashPresenter {

    private lateinit var binding : ActivitySplashBinding
    private lateinit var presenter : SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        presenter = SplashPresenter(this,this)
        //animaciones
        animation()
        Handler(Looper.getMainLooper()).postDelayed({ presenter.validateLogin() },2000)
    }
    private fun animation(){
        binding.lnBannerTop.animation = AnimationUtils.loadAnimation(this, R.anim.ani_top)
        binding.lnBannerBottom.animation = AnimationUtils.loadAnimation(this, R.anim.ani_bottom)

    }

    override fun validateLogin(valid: Boolean) {
        if (valid) HomeActivity.newInstance(this) else LoginActivity.newInstance(this)
        finish()
    }
}