package com.gb.vale.androidcoursemvvm.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityFormBinding
import com.gb.vale.androidcoursemvvm.utils.toastGeneric

class FormActivity : AppCompatActivity(),IRegisterPresenter {

    private lateinit var binding: ActivityFormBinding
    private lateinit var presenter : RegisterPresenter

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, FormActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        binding.lifecycleOwner = this
        presenter = RegisterPresenter(this)
        binding.btnRegister.setOnClickListener {
            presenter.register(
                binding.editUserRegister.text.toString().trim(),
                binding.editUserRegister.text.toString().trim()
            )
        }
    }

    override fun successRegister(value : Boolean) {
        if (value){
            toastGeneric("usuario creado")
            Handler(Looper.getMainLooper()).postDelayed({      finish() },500)
        }else{
            toastGeneric("error al crear dato")
        }
    }
}