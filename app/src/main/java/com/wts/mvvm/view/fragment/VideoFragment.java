package com.wts.mvvm.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wts.mvvm.R;
import com.wts.mvvm.VideoPlayerListener;
import com.wts.mvvm.common.Constant;
import com.wts.mvvm.model.VideoModel;
import com.wts.mvvm.video.VideoPlayerIjk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Create by wangtingshun 2019/9/2
 * describe 视频页fragment
 */
public class VideoFragment extends BaseFragment<VideoModel>{

    private VideoPlayerIjk ijkPlayer;
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ijkPlayer = view.findViewById(R.id.ijk_player);
        loadVideo();
        initListener();
    }

    @Override
    public void initData() {
         loadSo();
    }

    private void loadSo() {
        //加载so文件
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    @Override
    public void initView() {

    }

    public void initListener(){
        ijkPlayer.setListener(new VideoPlayerListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

            }

            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.seekTo(0);
                iMediaPlayer.start();
            }

            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.start();
            }

            @Override
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

            }
        });
    }

    public void loadVideo(){
        String videoPath = ijkPlayer.getVideoPath();
        ijkPlayer.setVideoPath(videoPath);
    }

    @Override
    public void onStop() {
        super.onStop();
        IjkMediaPlayer.native_profileEnd();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
