package com.test.sysco.utils

import android.util.Log
import com.test.sysco.BuildConfig

class Utils{
    companion object {
     fun log(tag: String?, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)
        }
    }
    }
}