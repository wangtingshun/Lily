package com.wts.mvvm.view.fragment

import com.wts.mvvm.R
import com.wts.mvvm.model.HomeModel

/**
 * Create by wangtingshun 2019/9/1
 * describe 首页fragment
 */
class HomeFragment : BaseFragment<HomeModel>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_layout
    }



}