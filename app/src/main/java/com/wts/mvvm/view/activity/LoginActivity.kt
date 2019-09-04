package com.wts.mvvm.view.activity

import com.wts.mvvm.R
import com.wts.mvvm.model.LoginModel

/**
 * Create by wangtingshun 2019/9/1
 * describe 登陆页
 */
class LoginActivity : BaseActivity<LoginModel>() {



    override fun initView() {
        //
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        //
    }

    override fun getViewModel(): LoginModel {
      return LoginModel()
    }

}