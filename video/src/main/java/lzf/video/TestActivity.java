package lzf.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private TextView textView;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_test);
        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Fade());
        textView= (TextView) findViewById(R.id.text);
    }
}
