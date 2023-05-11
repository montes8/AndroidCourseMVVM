package com.gb.`val`.androidcoursemvvm.ui.splash

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gb.`val`.androidcoursemvvm.ui.login.LoginActivity
import com.gb.`val`.androidcoursemvvm.R
import com.gb.`val`.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.`val`.androidcoursemvvm.ui.BaseActivity
import com.gb.`val`.androidcoursemvvm.ui.home.HomeActivity
import com.gb.`val`.androidcoursemvvm.ui.home.HomeActivity_GeneratedInjector
import com.gb.`val`.androidcoursemvvm.utils.animationBottom
import com.gb.`val`.androidcoursemvvm.utils.animationTop
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

     private lateinit var binding : ActivitySplashBinding
     private val viewModel : AppViewModel  by viewModels()

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.lnBannerTop.animationTop()
        binding.lnBannerBottom.animationBottom()
        viewModel.loadHome()
    }

    override fun observerViewModel() {
        viewModel.successSplash.observe(this){
            if (it) HomeActivity.newInstance(this) else LoginActivity.newInstance(this)
        }
    }

}