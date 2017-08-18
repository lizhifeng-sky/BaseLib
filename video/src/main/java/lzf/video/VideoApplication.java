package lzf.video;

import android.app.Application;

import com.pili.pldroid.player.widget.PLVideoTextureView;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class VideoApplication extends Application {
    private PLVideoTextureView plVideoTextureView;
    private static final VideoApplication videoApplication=new VideoApplication();
    public PLVideoTextureView getPlVideoTextureView() {
        return plVideoTextureView;
    }

    public void setPlVideoTextureView(PLVideoTextureView plVideoTextureView) {
        this.plVideoTextureView = plVideoTextureView;
    }

    public static VideoApplication getInstance(){
        return videoApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
