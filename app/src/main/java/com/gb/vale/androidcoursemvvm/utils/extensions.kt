package com.gb.vale.androidcoursemvvm.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.gb.vale.androidcoursemvvm.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.regex.Pattern

fun View.animationTop(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_top)
}

fun View.animationBottom(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_bottom)
}
fun Context.toastGeneric(message : String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

fun String.isEmailValid(): Boolean {
    return Pattern.compile(
        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(this).matches()
}


fun String.lengthPlus1(): Int {
    return this.length + 1
}


 suspend fun readFromAssets(context: Context, fileName: String): String {
    return  context.assets.open(fileName).bufferedReader().use { it.readText() }
}