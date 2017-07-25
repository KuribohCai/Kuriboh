package com.studio.cai.mysuperdemo.rxjava_retrofit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public class NetWork {
    private static ZhuangBiApi zhuangbiApi;
    private static LowPriceFlightApi lowPriceFlightApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static GsonConverterFactory sGsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory sFactory = RxJavaCallAdapterFactory.create();

    public static ZhuangBiApi getZhuangBiApi() {
        if (null == zhuangbiApi) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.zhuangbi.info/")
                    .addConverterFactory(sGsonConverterFactory)
                    .addCallAdapterFactory(sFactory)
                    .build();
            zhuangbiApi = retrofit.create(ZhuangBiApi.class);
        }
        return zhuangbiApi;
    }

    public static LowPriceFlightApi getLowPriceFlight() {
        if (null == lowPriceFlightApi) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://openapi.jinri.cn/app/FlightService.asmx/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(sFactory)
                    .build();

            lowPriceFlightApi = retrofit.create(LowPriceFlightApi.class);
        }
        return lowPriceFlightApi;
    }
}
