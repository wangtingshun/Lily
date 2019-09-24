package com.wts.mvvm.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wts.mvvm.viewModel.BaseViewModel

/**
 * Create by wangtingshun 2019/8/27
 * describe Fragment基类，所有fragment应该继承此类
 */

abstract class BaseFragment<T : BaseViewModel>: Fragment(){


    abstract fun getLayoutId() :Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
        initData()
    }


    private fun initViewModel() {

    }

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化View
     */
    abstract fun initView()


    abstract fun getViewModel() : T

}