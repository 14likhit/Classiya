package com.likhit.classiya.utils

import android.app.Activity
import android.content.Intent
import com.likhit.classiya.ui.home.HomeActivity
import com.likhit.classiya.ui.splash.SplashActivity

/**
 * File for launcher method of activity.
 */

fun launchSplashActivity(activity: Activity) {
    val intent = Intent(activity, SplashActivity::class.java)
    activity.startActivity(intent)
}

fun launchHomeActivity(activity: Activity) {
    val intent = Intent(activity, HomeActivity::class.java)
    activity.startActivity(intent)
}