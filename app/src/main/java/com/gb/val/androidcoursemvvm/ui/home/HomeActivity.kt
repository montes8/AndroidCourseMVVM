package com.gb.`val`.androidcoursemvvm.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gb.`val`.androidcoursemvvm.R
import com.gb.`val`.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.`val`.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.`val`.androidcoursemvvm.ui.BaseActivity
import com.gb.`val`.androidcoursemvvm.ui.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding : ActivityHomeBinding
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
    }

    override fun setView() {}

    override fun observerViewModel() {}

    override fun getViewModel(): BaseViewModel?  = null


}