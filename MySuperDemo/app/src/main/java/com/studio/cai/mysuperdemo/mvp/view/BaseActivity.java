package com.studio.cai.mysuperdemo.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator Kuriboh on 2017/4/21.
 */

public class BaseActivity extends AppCompatActivity {

    // 上下文 context
    public Context mContext;
    // 根界面 contentView
    public View mContentView;
    // 上个界面 isFrom

    // 网络请求等待 waitingDialog

    // 判断网络连接 isWifi,is4G/3G/2G

    // 请求错误界面,数据为空界面,网络繁忙界面 errorPage,nullPage,busyPage


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }
}
