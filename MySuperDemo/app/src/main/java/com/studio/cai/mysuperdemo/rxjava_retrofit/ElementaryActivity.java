package com.studio.cai.mysuperdemo.rxjava_retrofit;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.studio.cai.mysuperdemo.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public class ElementaryActivity extends AppCompatActivity {

    @BindView(R.id.recycleRV)
    RecyclerView mRecycleRV;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout mSwipeRefresh;

    ZhuangBiAdapter adapter = new ZhuangBiAdapter();
    Subscription subscription;

    Observer<List<ZhuangbiImage>> mObserver = new Observer<List<ZhuangbiImage>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSwipeRefresh.setRefreshing(false);
            Toast.makeText(ElementaryActivity.this, R.string.loading_failed, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(List<ZhuangbiImage> images) {
            Log.i("images", new Gson().toJson(images));
            mSwipeRefresh.setRefreshing(false);
            adapter.setImages(images);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementary);
        ButterKnife.bind(this);

        mRecycleRV.setLayoutManager(new GridLayoutManager(this, 2));
        mRecycleRV.setAdapter(adapter);

        mSwipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        mSwipeRefresh.setEnabled(false);

        LowPriceFlightListInfo bean = new LowPriceFlightListInfo();
        bean.setLoginInfo(new LowPriceFlightListInfo.LoginInfoBean(null,"tester001", "商旅APP_Android"));
        bean.setBusinessInfo(new LowPriceFlightListInfo.BusinessInfoBean("4.3.1"));
        Log.i("bean", new Gson().toJson(bean));
        NetWork.getLowPriceFlight()
                .lowPrice(new Gson().toJson(bean))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Log.i("callc", "00");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("calle", e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("call", s);
                    }
                });
    }

    @OnCheckedChanged({R.id.searchRB1, R.id.searchRB2, R.id.searchRB3, R.id.searchRB4})
    void onTagChecked(RadioButton searchRb, boolean checked) {
        if (checked) {
            unsubscribe();
            adapter.setImages(null);
            mSwipeRefresh.setRefreshing(true);
            search(searchRb.getText().toString());
        }
    }

    private void search(String key) {
        subscription = NetWork.getZhuangBiApi()
                .search(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    private void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
