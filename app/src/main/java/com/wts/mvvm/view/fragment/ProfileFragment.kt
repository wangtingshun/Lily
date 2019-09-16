package com.wts.mvvm.view.fragment

import android.os.Bundle
import com.wts.mvvm.R
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.ProfileModel

/**
 * Create by wangtingshun 2019/9/1
 * describe 我的fragment
 */
class ProfileFragment :BaseFragment<ProfileModel>() {

    override fun getViewModel(): ProfileModel = ProfileModel()

    override fun getLayoutId():Int {
        return R.layout.fragment_profile_layout
    }


    override fun initData() {

    }

    companion object {
        fun newInstance(title: String?): ProfileFragment {
            val bundle = Bundle()
            bundle.putString(Constant.TITLE, title)
            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


}