package com.wts.mvvm.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.wts.mvvm.R

/**
 * Create by wangtingshun 2019/9/8
 * describe 图片加载工具类
 */
object ImageLoadUtils {


    @JvmOverloads
  fun display(context: Context?, imageUrl:String?, imageView: ImageView,asBitmap:Boolean=false,defaultId:Int = R.mipmap.default_image_gray ) {
        if (context != null) {
            Glide.with(context).load(imageUrl).error(defaultId).into(imageView)
        }
    }


    fun display(context: Context?,resId:Int,loadingId:Int,imageView: ImageView,defaultId: Int = R.mipmap.default_image_gray){
            if (context != null){
                  Glide.with(context).load(resId).placeholder(loadingId).error(defaultId).into(imageView)
            }
    }



}