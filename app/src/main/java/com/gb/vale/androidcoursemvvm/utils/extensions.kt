package com.gb.vale.androidcoursemvvm.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.gb.vale.androidcoursemvvm.R

fun View.animationTop(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_top)
}

fun View.animationBottom(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_bottom)
}
fun Context.toastGeneric(message : String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}