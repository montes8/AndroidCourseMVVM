package com.gb.vale.androidcoursemvvm.ui.splash

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.vale.androidcoursemvvm.ui.BaseActivity
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.login.LoginActivity
import com.gb.vale.androidcoursemvvm.utils.animationBottom
import com.gb.vale.androidcoursemvvm.utils.animationTop
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: AppViewModel by viewModels()
    var value = false

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.lnBannerTop.animationTop()
        binding.lnBannerBottom.animationBottom()
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.loadValidateLogin()
        }, 2000)
    }

    override fun observerViewModel() {
        viewModel.successSplash.observe(this) {
            it?.let {
                if (it) HomeActivity.newInstance(this) else LoginActivity.newInstance(this)
                finish()
            }
        }
    }
}