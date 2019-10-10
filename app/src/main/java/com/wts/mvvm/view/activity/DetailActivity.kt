package com.wts.mvvm.view.activity

import com.wts.mvvm.R
import com.wts.mvvm.common.Constant
import com.wts.mvvm.model.DetailModel
import kotlinx.android.synthetic.main.activity_detail_layout.*

/**
 * Create by wangtingshun 2019/10/10
 * describe 详情
 */
class DetailActivity : BaseActivity<DetailModel>() {


    private var itemName: String? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_layout
    }

    override fun initData() {
        itemName = intent.getStringExtra(Constant.DATA)
    }

    override fun initView() {
        tv_detail?.text = itemName
    }

    override fun getViewModel(): DetailModel = DetailModel()
}