package com.wts.mvvm.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Create by wangtingshun 2019/9/7
 * describe viewPager Adapter
 */
class ViewPagerAdapter constructor(
    fm: FragmentManager,
    var fragments: MutableList<Fragment>
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size

}