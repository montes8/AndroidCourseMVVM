package com.gb.vale.androidcoursemvvm.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.register.FormActivity
import com.gb.vale.androidcoursemvvm.usecase.AppUseCase
import com.gb.vale.androidcoursemvvm.utils.toastGeneric

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var appUseCase : AppUseCase? = null
    private var viewModel : AppViewModel? = null

    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        appUseCase  = AppUseCase(this)
        viewModel = AppViewModel(appUseCase?:AppUseCase(this))
        //detectamos los editables mientras se escribe
        binding.editUserLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false }
        binding.editPassLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false}
        binding.btnLogin.setOnClickListener { if (validateLogin()) login() }


        //observadores
        viewModel?.successLogin?.observe(this){
            it?.let {
                HomeActivity.newInstance(this)
            }?:toastGeneric("Usuario incorrecto")
        }

        binding.textRegister.setOnClickListener { FormActivity.newInstance(this) }
    }

    private fun validateLogin(): Boolean {
        return viewModel?.validateLoginLabel(binding.editUserLogin,binding.editPassLogin,binding.editUserLayout
        ,binding.editPassLayout)?:false
    }

    private fun login() {
        viewModel?.login(binding.editUserLogin.text.toString(),binding.editPassLogin.text.toString())

    }
}