package com.wts.mvvm.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Create by wangtingshun 2019/9/7
 * describe 抽象的BasePagerAdapter
 */
abstract class BasePagerAdapter<T> constructor(
    var context: Context,
    var list: List<T>
) : PagerAdapter() {

    private val conventView = LinkedList<View>()

    /**
     * 设置pager view id
     */
    abstract val pagerId: Int

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
          val view = `object` as View
          conventView.add(view)
          container.removeView(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View
        if (conventView.size > 0) {
            view = conventView.removeAt(0)
        } else {
            view = View.inflate(context, pagerId, null)
        }
        initPagerData(view, position % list.size)
        container.addView(view)
        return view
    }

    /**
     *设置pager数据
     */
    abstract fun initPagerData(view: View, position: Int)
}