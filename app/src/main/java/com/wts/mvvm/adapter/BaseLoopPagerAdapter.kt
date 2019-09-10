package com.wts.mvvm.adapter

import android.content.Context
import android.view.View

/**
 * Create by wangtingshun 2019/9/8
 * describe 循环适配器
 */
abstract class BaseLoopPagerAdapter<T>(context: Context, list: List<T>) : BasePagerAdapter<T>(context, list) {


    override fun getCount(): Int {
        return if (list.size > 1) {
            Int.MAX_VALUE shr 2
        } else {
            list.size
        }
    }


    /**
     *设置pager数据
     */
    abstract override fun initPagerData(view: View, position: Int)
}