package com.gb.vale.androidcoursemvvm.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.gb.vale.androidcoursemvvm.R
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
                + "((([0-1]?\\d{1,2}|25[0-5]|2[0-4]\\d)\\.([0-1]?"
                + "\\d{1,2}|25[0-5]|2[0-4]\\d)\\."
                + "([0-1]?\\d{1,2}|25[0-5]|2[0-4]\\d)\\.([0-1]?"
                + "\\d{1,2}|25[0-5]|2[0-4]\\d))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    ).matcher(this).matches()
}


fun String.lengthPlus1(): Int {
    return this.length + 1
}
