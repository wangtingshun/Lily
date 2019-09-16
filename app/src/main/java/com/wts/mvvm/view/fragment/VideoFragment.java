package com.wts.mvvm.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.wts.mvvm.R;
import com.wts.mvvm.common.Constant;
import com.wts.mvvm.model.VideoModel;

/**
 * Create by wangtingshun 2019/9/2
 * describe 视频页fragment
 */
public class VideoFragment extends BaseFragment<VideoModel>{


    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_layout;
    }

    @Override
    public VideoModel getViewModel() {
        return new VideoModel();
    }

    public static VideoFragment newInstance(String title) {
        VideoFragment videoFragment = new VideoFragment();
        if (!TextUtils.isEmpty(title)) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TITLE, title);
            videoFragment.setArguments(bundle);
        }
        return videoFragment;
    }

    @Override
    public void initData() {

    }
}
