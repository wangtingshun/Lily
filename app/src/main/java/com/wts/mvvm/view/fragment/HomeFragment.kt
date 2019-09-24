package com.wts.mvvm.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.wts.mvvm.R
import com.wts.mvvm.adapter.HomeAdapter
import com.wts.mvvm.bean.HomeBean
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.HomeModel
import kotlinx.android.synthetic.main.fragment_home_layout.*

/**
 * Create by wangtingshun 2019/9/1
 * describe 首页fragment
 */
class HomeFragment : BaseFragment<HomeModel>() {

    private var homeAdapter: HomeAdapter? = null
    private var dataList: MutableList<HomeBean>? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_layout
    }

    override fun getViewModel():HomeModel = HomeModel()

    override fun initData() {
        dataList = arrayListOf()
        for (index in 1..10) {
            var bean = HomeBean()
            bean?.itemName = "第" + index + "个条目"
            dataList?.add(bean!!)
        }
 //       recyclerView?.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)
        homeAdapter = HomeAdapter(activity!!,dataList!!)
        recyclerView?.isNestedScrollingEnabled = false
        recyclerView?.adapter = homeAdapter
    }

    override fun initView() {
        //
    }


    companion object{
        fun newInstance(title: String?): HomeFragment {
            var bundle = Bundle()
            bundle.putString(Constant.TITLE, title)
            val fragment = HomeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}