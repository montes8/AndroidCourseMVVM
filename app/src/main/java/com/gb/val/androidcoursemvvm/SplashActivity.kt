package com.gb.`val`.androidcoursemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lnBannerTop.animation = AnimationUtils.loadAnimation(this,R.anim.ani_top)
        lnBannerBottom.animation = AnimationUtils.loadAnimation(this,R.anim.ani_bottom)
    }
}