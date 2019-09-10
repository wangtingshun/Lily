package com.wts.mvvm.bean

/**
 * Create by wangtingshun 2019/9/8
 * describe 首页banner数据类
 */
data class BannerBean(var title:String ,var list: MutableList<BannerListBean>) {

    /***
     *轮播图item数据
     */
    data class BannerListBean (var title: String,var image:String,var url:String)
}