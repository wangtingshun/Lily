package com.wts.mvvm.view.activity

import com.wts.mvvm.model.SplashModel

/**
 * Create by wangtingshun 2019/9/7
 * describe
 */
class SplashActivity :BaseActivity<SplashModel>() {


    override fun getLayoutId(): Int {
        return 0
    }

    override fun initData() {
        //
    }

    override fun initView() {
        //
    }

    override fun getViewModel(): SplashModel = SplashModel()
}