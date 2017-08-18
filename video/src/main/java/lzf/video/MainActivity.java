package lzf.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;

public class MainActivity extends Activity {
    private TextView textView;
    private FloatWindow floatWindow;
//    private PLVideoTextureView videoView;
    private PLVideoTextureView ownVideo;
    private String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    //当前播放的是否为在线直播，如果是，则底层会有一些播放优化
    private static final int IS_LIVE_STREAMING = 0;
    private RelativeLayout parent;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity_main);
        textView = (TextView) findViewById(R.id.text);
        ownVideo = (PLVideoTextureView) findViewById(R.id.ownVideo);
        parent= (RelativeLayout) findViewById(R.id.parent);
        VideoApplication.getInstance().setPlVideoTextureView(ownVideo);
        createPLDroidVTextureVideo();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                floatWindow=new FloatWindow(MainActivity.this);
//                createFloatView();
//                createFloatContentView();
//                floatWindow.show();
//                videoView.requestFocus();
//                videoView.start();
            }
        });
        ownVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.removeView(ownVideo);
                if (ownVideo.isPlaying()) {
                    VideoApplication.getInstance().getPlVideoTextureView().pause();
                }
                if (floatWindow==null) {
                    floatWindow = new FloatWindow(MainActivity.this);
                }
                createFloatView();
//                createFloatContentView();
                floatWindow.setPlayerView(VideoApplication.getInstance().getPlVideoTextureView());
                floatWindow.show();
                VideoApplication.getInstance().getPlVideoTextureView().start();
            }
        });
        ownVideo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("lzf_touch","1111111");
                parent.removeView(ownVideo);
                if (ownVideo.isPlaying()) {
                    VideoApplication.getInstance().getPlVideoTextureView().pause();
                }
                if (floatWindow==null) {
                    floatWindow = new FloatWindow(MainActivity.this);
                }
                createFloatView();
//                createFloatContentView();
                floatWindow.setPlayerView(VideoApplication.getInstance().getPlVideoTextureView());
                floatWindow.show();
                VideoApplication.getInstance().getPlVideoTextureView().start();
                return false;
            }
        });

    }

    private void createPLDroidVTextureVideo() {
//        ownVideo.setVideoURI(Uri.parse(url));
        AVOptions options = new AVOptions();
        // the unit of timeout is ms
        options.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
        ownVideo.setAVOptions(options);
//        ownVideo.setMediaController(new lzf.video.MediaController(this));
        ownVideo.setVideoPath(url);
        ownVideo.start();
    }

    private void createFloatContentView() {
//        View view = LayoutInflater.from(this).inflate(R.layout.video_play, null);
//        videoView = (PLVideoTextureView) view.findViewById(R.id.videoView);
//        AVOptions options = new AVOptions();
//        // the unit of timeout is ms
//        options.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
//        videoView.setAVOptions(options);
//        videoView.setMediaController(new lzf.video.MediaController(this));
//        videoView.setVideoPath(url);
//        floatWindow.setPlayerView(view);
    }

    private void createFloatView() {
        TextView floatTextView = new TextView(MainActivity.this);
        floatTextView.setText("video");
        floatTextView.setTextColor(Color.RED);
        floatTextView.setTextSize(40);
        floatWindow.setFloatView(floatTextView);
    }
}
