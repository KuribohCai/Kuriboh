package com.studio.cai.mysuperdemo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator Kuriboh on 2017/7/18.
 */

public interface IWeather {
    @GET("/v3/weather/now.json")
    Call<WeatherBean> weather(@Query("key")String key,@Query("location")String location);
}
