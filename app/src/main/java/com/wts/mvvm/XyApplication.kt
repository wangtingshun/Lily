package com.wts.mvvm

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.support.multidex.MultiDexApplication

/**
 * Create by wangtingshun 2019/8/24
 * describe
 */

class XyApplication :MultiDexApplication(){

    companion object{
        var application: XyApplication? = null
        var isDebug = BuildConfig.isDebug  //已在gradle配置相应的值
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    val handler by lazy {
        Handler(Looper.getMainLooper())
    }

    private val activityContainer = ArrayList<Activity>()

    fun getActivityContainer(): ArrayList<Activity> {
        return activityContainer
    }

    fun removeAllActivity() {
        for (oldActivity in activityContainer) {
            oldActivity.finish()
        }
        activityContainer.clear()
    }

}