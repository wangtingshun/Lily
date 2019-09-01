package com.wts.mvvm.http

import com.wts.mvvm.utils.AppUtils
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Create by wangtingshun 2019/8/24
 * describe 封装网络请求
 */

class OkHttpUtils private constructor(){

    private val mOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .cache(Cache(AppUtils.getContext().cacheDir, (10 * 1024 * 1024.toLong())))
        .build()

     companion object{     //单例 懒汉式
         val mInstance : OkHttpUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
               OkHttpUtils()
         }
     }

}