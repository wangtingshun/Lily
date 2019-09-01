package com.wts.mvvm.utils;

import android.content.Context;
import com.wts.mvvm.XyApplication;

/**
 * Create by wangtingshun 2019/8/24
 * describe
 */
public final class AppUtils {

    private AppUtils(){}


    public static Context getContext(){
       return XyApplication.Companion.getApplication();
    }
}
