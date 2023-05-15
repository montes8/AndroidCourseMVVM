package com.gb.vale.androidcoursemvvm.utils

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.gb.vale.androidcoursemvvm.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.toastGeneric(message : String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}


fun Context.dialogSimple(
    title: String = getString(R.string.text_logout), subTitle: String =
        getString(R.string.text_logout_sub), btnYes: String =
        getString(R.string.text_yes), btnNot: String =
        getString(R.string.text_not),
    actionClick: ((action: Boolean) -> Unit)? = null
) {
    MaterialAlertDialogBuilder(this, R.style.MaterialAlertDialogCenter)
        .setTitle(title)
        .setMessage(subTitle)
        .setBackground(ContextCompat.getDrawable(this, R.drawable.bg_border_white))
        .setNegativeButton(btnNot) { dialog, _ ->
            dialog.dismiss()
            actionClick?.invoke(false)
        }
        .setPositiveButton(btnYes) { dialog, _ ->
            dialog.dismiss()
            actionClick?.invoke(true)
        }
        .show()
}