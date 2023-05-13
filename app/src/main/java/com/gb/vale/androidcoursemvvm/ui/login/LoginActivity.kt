package com.gb.vale.androidcoursemvvm.ui.login

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.vale.androidcoursemvvm.ui.BaseActivity
import com.gb.vale.androidcoursemvvm.ui.home.HomeActivity
import com.gb.vale.androidcoursemvvm.ui.splash.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: AppViewModel by viewModels()

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.editUserLogin.addTextChangedListener {
            binding.editUserLayout.isErrorEnabled = false
        }
        binding.editPassLogin.addTextChangedListener {
            binding.editUserLayout.isErrorEnabled = false
        }
        binding.btnLogin.setOnClickListener { if (validateLogin()) login() }
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
        viewModel.login(
            binding.editUserLogin.text.toString(),
            binding.editPassLogin.text.toString()
        )
    }

    override fun observerViewModel() {
        viewModel.successLogin.observe(this) {
            it?.let {
                HomeActivity.newInstance(this)
            }
        }
    }

}