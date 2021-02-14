package com.example.appnexttestapp

import android.util.Log


const val TAG = "AppsList"

fun logD(string: String) {
    if (BuildConfig.DEBUG) Log.d(TAG, string)
}

fun logE(string: String) {
    if (BuildConfig.DEBUG) Log.e(TAG, string)
}