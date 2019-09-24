package com.wts.mvvm;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Create by wangtingshun 2019/9/19
 * describe 播放器监听
 */
public abstract class VideoPlayerListener implements IMediaPlayer.OnBufferingUpdateListener,IMediaPlayer.OnCompletionListener,
        IMediaPlayer.OnPreparedListener,IMediaPlayer.OnInfoListener,IMediaPlayer.OnVideoSizeChangedListener,
        IMediaPlayer.OnErrorListener,IMediaPlayer.OnSeekCompleteListener{


}
