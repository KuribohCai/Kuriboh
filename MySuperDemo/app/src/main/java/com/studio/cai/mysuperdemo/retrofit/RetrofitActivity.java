package com.studio.cai.mysuperdemo.retrofit;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.studio.cai.mysuperdemo.R;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator Kuriboh on 2017/7/18.
 */

public class RetrofitActivity extends FragmentActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thinkpage.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<WeatherBean> call = iWeather.weather("rot2enzrehaztkdk", "beijing");
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                WeatherBean body = response.body();
                Log.i("cylog", body.results.get(0).now.temperature + "");
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                Log.i("cylog", "Error" + t.toString());
            }
        });
    }
}
