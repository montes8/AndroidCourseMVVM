package com.gb.vale.androidcoursemvvm.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityHomeBinding
import com.gb.vale.androidcoursemvvm.databinding.ActivityLoginBinding
import com.gb.vale.androidcoursemvvm.ui.AppViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var shared : SharedPreferences? = null
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this

        //inicializamos el sharedPreference
        shared = getSharedPreferences("myPreference", MODE_PRIVATE)

        //simulamos cerrar sesion
        binding.textLogout.setOnClickListener {
           shared?.edit()?.putBoolean("token",false)?.apply()
            finish()
        }

    }


}