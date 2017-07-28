package com.studio.cai.mysuperdemo.databinding;

import android.databinding.DataBindingUtil;
import com.studio.cai.mysuperdemo.databinding.ActivityDatabindingBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.studio.cai.mysuperdemo.R;

/**
 * Created by Administrator Kuriboh on 2017/7/26.
 */

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        User user=new User("donkor",10,"http://blog.csdn.net/donkor_");
        user.setImageUrl("http://img.blog.csdn.net/20170117223343303?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZG9ua29yXw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast");
        dataBinding.setUser(user);
    }
}
