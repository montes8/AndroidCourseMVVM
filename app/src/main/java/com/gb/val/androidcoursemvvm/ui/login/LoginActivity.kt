package com.gb.`val`.androidcoursemvvm.ui.login

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.gb.`val`.androidcoursemvvm.R
import com.gb.`val`.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.`val`.androidcoursemvvm.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding : ActivityLoginBinding
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
    }

    override fun setView() {}

    override fun observerViewModel() {}

}