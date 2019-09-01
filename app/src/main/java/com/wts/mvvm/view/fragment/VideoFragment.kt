package com.wts.mvvm.view.fragment

import com.wts.mvvm.R
import com.wts.mvvm.model.VideoModel

/**
 * Create by wangtingshun 2019/9/1
 * describe 视频fragment
 */
class VideoFragment:BaseFragment<VideoModel>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_video_layout
    }

}