package com.wts.mvvm.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.wts.mvvm.R
import com.wts.mvvm.bean.BannerBean
import com.wts.mvvm.utils.ImageLoadUtils

/**
 * Create by wangtingshun 2019/9/8
 * describe
 */
class BannerAdapter(
    context: Context, list: ArrayList<BannerBean.BannerListBean>
) : BaseLoopPagerAdapter<BannerBean.BannerListBean>(context, list) {


    override val pagerId: Int get() = R.layout.dashboard_banner


    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun initPagerData(view: View, position: Int) {
        var imageview: ImageView = view.findViewById(R.id.image)
        var bean = list[position % list.size]
        ImageLoadUtils.display(context, bean.image, imageview, false, R.mipmap.default_image_gray)
    }

}