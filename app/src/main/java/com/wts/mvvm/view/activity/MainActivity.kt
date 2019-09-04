package com.wts.mvvm.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.wts.mvvm.R
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.MainModel
import com.wts.mvvm.view.fragment.HomeFragment
import com.wts.mvvm.view.fragment.ProfileFragment
import com.wts.mvvm.view.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Create by wangtingshun 2019/9/1
 * describe
 */
class MainActivity : BaseActivity<MainModel>() {

    var fragmentManager: FragmentManager? = null
    var fragments: ArrayList<Fragment>? = null
    var homeFragment: HomeFragment? = null
    var videoFragment: VideoFragment? = null
    var profileFragment: ProfileFragment? = null
    var transition: FragmentTransaction? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListener()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        fragments = ArrayList()
        fragmentManager = supportFragmentManager
        homeFragment = HomeFragment.newInstance(Constant.HOME)
        homeFragment?.let {
            fragments?.add(it)
        }

       hideOtherFragment(homeFragment,true)
    }

    override fun initData() {

    }

    override fun getViewModel(): MainModel {
          return MainModel()
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        jumpFragmentPage(intent)
    }


    private fun jumpFragmentPage(intent: Intent?) {
        val pageTab = intent?.getStringExtra(Constant.HOME_TAB)
        when (pageTab) {
            Constant.HOME_PAGE -> {
                rg_group.check(R.id.rb_home)
                view_pager.setCurrentItem(0,false)
            }
            Constant.VIDEO_PAGE -> {
                rg_group.check(R.id.rb_video)
                view_pager.setCurrentItem(1,false)
            }
            Constant.PROFILE_PAGE -> {
                rg_group.check(R.id.rb_me)
                view_pager.setCurrentItem(2,false)
            }
        }
    }


    private fun hideOtherFragment(showFragment: Fragment?, add: Boolean) {
        transition = fragmentManager?.beginTransaction()
        if (add) {
            transition?.add(R.id.content,showFragment!!)
        }
        for (fragment in fragments!!) {
            if (showFragment === fragment) {
                transition?.show(fragment)
            } else {
                transition?.hide(fragment)
            }
        }
        transition?.commit()
    }


    private fun initListener() {
        rg_group.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId){
                R.id.rb_home ->      //首页
                    hideOtherFragment(homeFragment, false)
                R.id.rb_video ->       //视频
                    if (videoFragment == null){
                        videoFragment = VideoFragment.newInstance(Constant.VIDEO)
                        fragments?.add(videoFragment!!)
                        hideOtherFragment(videoFragment,true)
                    } else {
                       hideOtherFragment(videoFragment,false)
                    }
                R.id.rb_me ->      //我的
                    if (profileFragment == null) {
                        profileFragment = ProfileFragment.newInstance(Constant.PROFILE)
                        fragments?.add(profileFragment!!)
                        hideOtherFragment(profileFragment,true)
                    } else {
                        hideOtherFragment(profileFragment,false)
                    }
               }
         }
    }
}