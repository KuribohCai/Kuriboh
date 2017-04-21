package com.studio.cai.mysuperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.studio.cai.mysuperdemo.ui.BannerActivity;
import com.studio.cai.mysuperdemo.ui.GuideActivity;
import com.studio.cai.mysuperdemo.ui.MoreTabActivity;
import com.studio.cai.mysuperdemo.ui.SpringActivity;
import com.studio.cai.mysuperdemo.ui.TabMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.button_banner)
    Button mButtonBanner;
    @BindView(R.id.button_guide)
    Button mButtonGuide;
    @BindView(R.id.button_main)
    Button mButtonMain;
    @BindView(R.id.button_tab)
    Button mButtonTab;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.button_sticktab)
    Button mButtonSticktab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @OnClick({R.id.button_banner, R.id.button_guide, R.id.button_main, R.id.button_tab,R.id.button_sticktab, R.id.activity_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_banner:
                startActivity(new Intent(getApplicationContext(), BannerActivity.class));
                break;
            case R.id.button_guide:
                startActivity(new Intent(getApplicationContext(), GuideActivity.class));
                break;
            case R.id.button_main:
                startActivity(new Intent(getApplicationContext(), TabMainActivity.class));
                break;
            case R.id.button_tab:
                startActivity(new Intent(getApplicationContext(), MoreTabActivity.class));
                break;
            case R.id.button_sticktab:
                startActivity(new Intent(getApplicationContext(), SpringActivity.class));
                break;
            case R.id.activity_main:
                break;
        }
    }

}
