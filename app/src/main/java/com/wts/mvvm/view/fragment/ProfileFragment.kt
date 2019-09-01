package com.wts.mvvm.view.fragment

import com.wts.mvvm.R
import com.wts.mvvm.model.ProfileModel

/**
 * Create by wangtingshun 2019/9/1
 * describe 我的fragment
 */
class ProfileFragment :BaseFragment<ProfileModel>() {

    override fun getLayoutId():Int {
        return R.layout.fragment_profile_layout
    }
}