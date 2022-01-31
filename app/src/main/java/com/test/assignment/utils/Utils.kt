package com.test.assignment.utils

import android.util.Log
import com.test.assignment.BuildConfig

class Utils{
    companion object {
     fun log(tag: String?, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)
        }
    }
    }
}