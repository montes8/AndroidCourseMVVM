package com.gb.vale.androidcoursemvvm.ui.utils

import android.content.Context
import android.widget.Toast

fun Context.toasGeneric(message : String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}