package com.wts.mvvm.view.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.wts.mvvm.R
import com.wts.mvvm.adapter.HomeAdapter
import com.wts.mvvm.bean.HomeBean
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.HomeModel
/**
 * Create by wangtingshun 2019/9/1
 * describe 首页fragment
 */
class HomeFragment : BaseFragment<HomeModel>() {


    private val recyclerView: RecyclerView? = null
    private var homeAdapter: HomeAdapter? = null
    private var dataList: MutableList<HomeBean>? = null


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_layout
    }

    override fun getViewModel():HomeModel = HomeModel()


    override fun initData() {
        recyclerView?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        homeAdapter = HomeAdapter(activity!!,dataList!!)
        recyclerView?.adapter = homeAdapter
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