package com.wts.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.wts.mvvm.view.LoadingDialog
import com.wts.mvvm.viewModel.BaseViewModel

/**
 * 此类为所有类的基类，所有activity都应该继承
 *
 */
abstract class BaseActivity<T : BaseViewModel>: AppCompatActivity() {


    var pageName:String? = null
    var mViewModel: T? = null
    var loadingDialog: LoadingDialog? = null
    var isRegisterEventBus = false
    var dataTrackPageMap: HashMap<String,String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(getLayoutId())
        initViewModel()
        initData()
        initView()
        initListener()
    }


    /**
     *layoutID 子类必须实现
     */
    abstract fun getLayoutId(): Int


    /**
     *初始化数据，子类必须实现
     */
    abstract fun initData()

    /**
     * 初始化View
     */
    abstract fun initView()

    private fun initViewModel(){
           mViewModel = ViewModelProviders.of(this).get(getViewModel()::class.java)
           mViewModel?.showLoadDialog?.observe(this, Observer {
                 it?.let {
                      if (it){
                           openLoadingDialog()
                      } else {
                           closeLoadingDialog()
                      }
                 }
           })
    }

    private fun closeLoadingDialog() {

    }

    private fun openLoadingDialog() {

    }

    abstract fun getViewModel(): T
    /**
     * 初始化监听，子类选择是否实现
     */
    private fun initListener() {

    }

    open fun lazyLoad(){   //do something

    }
}