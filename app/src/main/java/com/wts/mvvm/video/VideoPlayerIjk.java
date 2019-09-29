package com.wts.mvvm.video;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.wts.mvvm.VideoPlayerListener;
import com.wts.mvvm.utils.ConfigUrl;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import java.io.IOException;

/**
 * Create by wangtingshun 2019/9/19
 * describe视频播放器
 */
public class VideoPlayerIjk extends FrameLayout {

    /**
     * 由ijkPlayer提供，用于视频播放，需要传入一个surfaceView
     */
    private IMediaPlayer mMediaPlayer = null;
    /**
     * 视频播放地址
     */
    private String mPath = "";

    private SurfaceView surfaceView;
    private VideoPlayerListener listener;
    private Context mContext;


    public VideoPlayerIjk(Context context) {
        super(context);
        initVideoView(context);
    }

    public VideoPlayerIjk(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        this.mContext = context;
    }


    /**
     * 设置视频地址
     * 根据是否第一次播放视频，做不同的操作
     * @param path
     */
    public void setVideoPath(String path){
        if (TextUtils.equals("",mPath)){
            mPath = path;
            createSurfaceView();
        } else {
            mPath = path;
            load();
        }
    }

    private void createSurfaceView() {
          surfaceView = new SurfaceView(mContext);
          surfaceView.getHolder().addCallback(new LmnSurfaceCallBack());
          LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, Gravity.CENTER);
          surfaceView.setLayoutParams(layoutParams);
          this.addView(surfaceView);
    }

    /**
     *加载视频
     */
    private void load() {
        //每次都要重新创建IMediaPlayer
        createPlayer();
        try {
            mMediaPlayer.setDataSource(mPath);
        } catch (IOException e){
            e.printStackTrace();
        }
       //给mediaPlayer设置视图
        mMediaPlayer.setDisplay(surfaceView.getHolder());
        mMediaPlayer.prepareAsync();
    }

    private void createPlayer() {
        if (mMediaPlayer != null){
            mMediaPlayer.stop();
            mMediaPlayer.setDisplay(null);
            mMediaPlayer.release();
        }

        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        ijkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);

        //开启硬编码
        ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER,"mediacodec",1);
        mMediaPlayer = ijkMediaPlayer;

        if (listener != null){
            mMediaPlayer.setOnPreparedListener(listener);
            mMediaPlayer.setOnBufferingUpdateListener(listener);
            mMediaPlayer.setOnSeekCompleteListener(listener);
            mMediaPlayer.setOnInfoListener(listener);
            mMediaPlayer.setOnErrorListener(listener);
        }
    }


    public void setListener(VideoPlayerListener listener){
        this.listener = listener;
        if (mMediaPlayer != null){
            mMediaPlayer.setOnPreparedListener(listener);
        }
    }

    public class LmnSurfaceCallBack implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            //surfaceView创建成功后加载
                load();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    public String getVideoPath(){
        return ConfigUrl.video_path;
    }

    public void start(){
        if (mMediaPlayer != null){
            mMediaPlayer.start();
        }
    }

    public void release(){
        if (mMediaPlayer != null){
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void pause(){
        if (mMediaPlayer != null){
            mMediaPlayer.pause();
        }
    }


    public void stop(){
        if (mMediaPlayer != null){
            mMediaPlayer.stop();
        }
    }

    public void reset(){
        if (mMediaPlayer != null){
            mMediaPlayer.reset();
        }
    }

    public long getDuration(){
        if (mMediaPlayer != null){
            return mMediaPlayer.getDuration();
        } else {
            return 0;
        }
    }

    public long getCurrentPosition(){
        if (mMediaPlayer != null){
            return mMediaPlayer.getCurrentPosition();
        } else {
            return  0;
        }
    }

    public void seekTo(long l){
        if (mMediaPlayer != null){
            mMediaPlayer.seekTo(l);
        }
    }

}
