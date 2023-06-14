package com.gb.vale.androidcoursemvvm.ui.register

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityFormBinding
import com.gb.vale.androidcoursemvvm.ui.BaseActivity
import com.gb.vale.androidcoursemvvm.utils.toastGeneric
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormActivity : BaseActivity() {

    private lateinit var binding : ActivityFormBinding
    private val viewModel: RegisterViewModel by viewModels()

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, FormActivity::class.java))
    }
    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.btnRegister.setOnClickListener {
            viewModel.register(binding.editUserRegister.text.toString().trim(),
                binding.editRegisterLogin.text.toString().trim()
            )
        }
    }

    override fun observerViewModel() {
        viewModel.successRegister.observe(this){
            if (it){
                toastGeneric("usuariuo creado")
                finish()
            }else{
                toastGeneric("error al crear usuario")
            }
        }}

}