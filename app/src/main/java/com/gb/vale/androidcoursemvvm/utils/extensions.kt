package com.gb.vale.androidcoursemvvm.utils

import android.view.View
import android.view.animation.AnimationUtils
import com.gb.vale.androidcoursemvvm.R

fun View.animationTop(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_top)
}

fun View.animationBottom(){
    this.animation = AnimationUtils.loadAnimation(this.context, R.anim.ani_bottom)
}