package com.gb.vale.androidcoursemvvm.ui.register

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gb.vale.androidcoursemvvm.R
import com.gb.vale.androidcoursemvvm.databinding.ActivityFormBinding
import com.gb.vale.androidcoursemvvm.databinding.ActivitySplashBinding
import com.gb.vale.androidcoursemvvm.ui.application.ACMApplication
import com.gb.vale.androidcoursemvvm.ui.db.entity.UserEntity
import com.gb.vale.androidcoursemvvm.ui.login.LoginActivity
import com.gb.vale.androidcoursemvvm.ui.utils.toasGeneric
import kotlin.concurrent.thread

class FormActivity : AppCompatActivity() {


    private lateinit var binding : ActivityFormBinding
    var handler : Handler = Handler( Looper.getMainLooper())

    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context, FormActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        binding.lifecycleOwner = this
        binding.btnRegister.setOnClickListener {
            thread(start = true){
               val id =  ACMApplication.database?.userDao()?.insert(UserEntity(
                      name = binding.editUserRegister.text.toString().trim(),
                              pass = binding.editUserRegister.text.toString().trim(),
                   token = "dfghjlkjhgmnb"
                ))

                handler.post {
                    if (id != null){
                        toasGeneric("usuario creado")
                        finish()
                    }else{
                        toasGeneric("error al crear dato")
                    }
                }


            }
        }

    }
}