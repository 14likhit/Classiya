package com.likhit.classiya.ui.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.likhit.classiya.R
import com.likhit.classiya.base.BaseActivity
import com.likhit.classiya.databinding.ActivitySplashBinding
import com.likhit.classiya.utils.launchHomeActivity

class SplashActivity : BaseActivity() {

    private lateinit var activitySplashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        startTimer()
    }

    private fun startTimer() {
        activitySplashBinding.root.postDelayed({
            launchHomeActivity(this@SplashActivity)
            finish()
        }, 250)
    }
}