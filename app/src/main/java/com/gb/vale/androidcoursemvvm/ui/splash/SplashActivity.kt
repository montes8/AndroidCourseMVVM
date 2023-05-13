package com.gb.vale.androidcoursemvvm.ui.splash

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private val viewModel : AppViewModel = AppViewModel()
    private var shared : SharedPreferences? = null
    private var flagLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        animation()
        shared = getSharedPreferences("myPreference", MODE_PRIVATE)
        flagLogin = shared?.getBoolean("token",false)?:false
        viewModel.validateLogin()
        viewModel.successSplash.observe(this){
            if (flagLogin) HomeActivity.newInstance(this) else LoginActivity.newInstance(this)
            finish()
        }
    }
    private fun animation(){
        binding.lnBannerTop.animation = AnimationUtils.loadAnimation(this, R.anim.ani_top)
        binding.lnBannerBottom.animation = AnimationUtils.loadAnimation(this, R.anim.ani_bottom)

    }
}