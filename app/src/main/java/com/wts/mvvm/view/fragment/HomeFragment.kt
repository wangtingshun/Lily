package com.wts.mvvm.view.fragment

import android.os.Bundle
import com.wts.mvvm.R
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.HomeModel
/**
 * Create by wangtingshun 2019/9/1
 * describe 首页fragment
 */
class HomeFragment : BaseFragment<HomeModel>() {



    override fun getLayoutId(): Int {
        return R.layout.fragment_home_layout
    }

    override fun getViewModel():HomeModel = HomeModel()


    companion object{
        fun newInstance(title: String?):HomeFragment{
            var bundle = Bundle()
            bundle.putString(Constant.TITLE,title)
            val fragment = HomeFragment()
            fragment.arguments = bundle
            return  fragment
        }
    }

}