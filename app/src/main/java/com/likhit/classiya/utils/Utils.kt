package com.likhit.classiya.utils

import android.content.Context

/**
 * Utility file for utils functions.
 */

fun pxToDp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}

fun dpToPx(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}