package com.gb.vale.androidcoursemvvm.ui.home

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.vale.androidcoursemvvm.ui.BaseActivity
import com.gb.vale.androidcoursemvvm.ui.BaseViewModel
import com.gb.vale.androidcoursemvvm.ui.splash.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: AppViewModel by viewModels()

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.textLogout.setOnClickListener {
            viewModel.logout()
            finish()
        }
    }

    override fun observerViewModel() {}

    override fun getViewModel(): BaseViewModel? = null

}