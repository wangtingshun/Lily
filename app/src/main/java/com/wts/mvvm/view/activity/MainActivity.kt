package com.wts.mvvm.view.activity

import com.wts.mvvm.R
import com.wts.mvvm.model.MainModel

/**
 * Create by wangtingshun 2019/9/1
 * describe
 */
class MainActivity : BaseActivity<MainModel>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {

    }

    override fun getViewModel(): MainModel {
          return MainModel()
    }

}