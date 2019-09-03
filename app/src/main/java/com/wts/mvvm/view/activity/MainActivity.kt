package com.wts.mvvm.view.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.wts.mvvm.R
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.MainModel
import com.wts.mvvm.view.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Create by wangtingshun 2019/9/1
 * describe
 */
class MainActivity : BaseActivity<MainModel>() {


    var fragmentManager: FragmentManager? = null
    var fragments: ArrayList<Fragment>? = null
    var homeFragment: HomeFragment? = null
    var transition: FragmentTransaction? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        fragments = ArrayList()
        fragmentManager = supportFragmentManager
        homeFragment = HomeFragment.newInstance("首页")
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
//        for ( fragment in fragments){
//
//        }
    }


    private fun initListener() {

    }
}