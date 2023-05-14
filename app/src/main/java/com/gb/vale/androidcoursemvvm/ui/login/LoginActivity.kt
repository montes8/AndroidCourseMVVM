package com.gb.vale.androidcoursemvvm.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.register.FormActivity
import com.gb.vale.androidcoursemvvm.ui.utils.toastGeneric

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var shared : SharedPreferences? = null
    private val viewModel : AppViewModel = AppViewModel()

    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        //inicializamos el sharedPreference
        shared = getSharedPreferences("myPreference", MODE_PRIVATE)

        //detectamos los editables mientras se escribe
        binding.editUserLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false }
        binding.editPassLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false}

        binding.btnLogin.setOnClickListener { if (validateLogin()) login() }


        //observadores
        viewModel.successLogin.observe(this){
            it?.let {
                shared?.edit()?.putBoolean("token",it.token.isNotEmpty())?.apply()
                HomeActivity.newInstance(this)
            }?:toastGeneric("Usuario incorrecto")
        }

        binding.textRegister.setOnClickListener { FormActivity.newInstance(this) }
    }

    private fun validateLogin(): Boolean {
        if (binding.editUserLogin.text.toString().isEmpty()) {
            binding.editUserLayout.isErrorEnabled = true
            binding.editUserLayout.error = "Necesitas ingresar el dato"
            return false
        }

        if (binding.editPassLogin.text.toString().isEmpty()) {
            binding.editPassLayout.isErrorEnabled = true
            binding.editPassLayout.error = "Necesitas ingresar el dato"
            return false
        }
        return true
    }

    private fun login() {
        viewModel.login(binding.editUserLogin.text.toString(),binding.editPassLogin.text.toString())

    }
}