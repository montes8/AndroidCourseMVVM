package com.gb.vale.androidcoursemvvm.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityFormBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel
import com.gb.vale.androidcoursemvvm.usecase.AppUseCase
import com.gb.vale.androidcoursemvvm.utils.toastGeneric

class FormActivity : AppCompatActivity() {


    private lateinit var binding: ActivityFormBinding
    private var appUseCase: AppUseCase? = null
    private var viewModel: AppViewModel? = null

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, FormActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        binding.lifecycleOwner = this

        appUseCase = AppUseCase(this)
        viewModel = AppViewModel(appUseCase ?: AppUseCase(this))

        binding.btnRegister.setOnClickListener {
            viewModel?.register(
                binding.editUserRegister.text.toString().trim(),
                binding.editUserRegister.text.toString().trim()
            )

            viewModel?.successRegister?.observe(this) {
                it?.let {
                    toastGeneric("usuario creado")
                    finish()
                } ?: toastGeneric("error al crear dato")
            }
        }
    }
}