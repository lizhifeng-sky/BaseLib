package lzf.baselib;

import android.annotation.TargetApi;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import lzf.common.network.BaseView;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.SchedulesTransformer;
import lzf.common.network.bean.GuideBean;

public class MainActivity extends AppCompatActivity implements BaseView {
    private SoundPool soundPool;
    private int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSound();
    }

    public void doHttp(View view) {
        playSound();
        apiService.getStartView(2)
                .compose(new SchedulesTransformer<List<GuideBean>>())
                .subscribe(new CustomSubscriber<List<GuideBean>>() {
                    @Override
                    public void onSuccess(List<GuideBean> guideBeen) {
                        Log.e("lzf", guideBeen.toString());
                    }
                });
    }

    private void playSound() {
        soundPool.play(soundId,
                0.1f,
                0.5f,
                0,
                1,
                1);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundId = soundPool.load(this, R.raw.test, 1);
    }

    @Override
    public void prepareData() {

    }

    @Override
    public void findView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setPresenter() {

    }
}