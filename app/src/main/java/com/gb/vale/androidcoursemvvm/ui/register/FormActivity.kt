package com.gb.vale.androidcoursemvvm.ui.register

import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityFormBinding
import com.gb.vale.androidcoursemvvm.ui.BaseActivity

class FormActivity : BaseActivity() {

    private lateinit var binding : ActivityFormBinding

    override fun getBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        binding.lifecycleOwner = this
    }

    override fun setView() {
        binding.btnRegister.setOnClickListener {

        }
    }

    override fun observerViewModel() {

    }

}