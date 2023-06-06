package com.gb.vale.androidcoursemvvm.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.model.User
import com.gb.vale.androidcoursemvvm.ui.register.FormActivity
import com.gb.vale.androidcoursemvvm.utils.toastGeneric
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() ,ILoginPresenter{

    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter : LoginPresenter

    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        presenter = LoginPresenter(this,this)
        //detectamos los editables mientras se escribe
        binding.editUserLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false }
        binding.editPassLogin.addTextChangedListener { binding.editUserLayout.isErrorEnabled = false}
        binding.btnLogin.setOnClickListener { if (validateLogin()) login() }
        binding.textRegister.setOnClickListener { FormActivity.newInstance(this) }
    }

    private fun validateLogin(): Boolean {
        return validateLoginLabel(binding.editUserLogin,binding.editPassLogin,binding.editUserLayout
        ,binding.editPassLayout)
    }

    private fun login() {

        presenter.login(binding.editUserLogin.text.toString(),binding.editPassLogin.text.toString())

    }

    override fun successLogin(user: User?) {
        user?.let {
            HomeActivity.newInstance(this)
        }?:toastGeneric("Usuario incorrecto")
    }

    fun validateLoginLabel(editUser : TextInputEditText, editPass : TextInputEditText,
                           editUserL : TextInputLayout, editPassL : TextInputLayout
    ): Boolean {
        if (editUser.text.toString().isEmpty()) {
            editUserL.isErrorEnabled = true
            editUserL.error = "Necesitas ingresar el dato"
            return false
        }

        if (editPass.text.toString().isEmpty()) {
            editPassL.isErrorEnabled = true
            editPassL.error = "Necesitas ingresar el dato"
            return false
        }
        return true
    }
}