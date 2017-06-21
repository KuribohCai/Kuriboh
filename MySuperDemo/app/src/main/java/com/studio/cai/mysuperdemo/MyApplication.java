package com.studio.cai.mysuperdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by Administrator Kuriboh on 2017/5/11.
 */

public class MyApplication extends Application {

    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }
}
