package com.studio.cai.mysuperdemo.rxjava_retrofit;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public interface LowPriceFlightApi {
    // "http://openapi.jinri.cn" + "/app/FlightService.asmx" + "/" +"GetLowPriceFlightList"
//     {"requestXml":"{\"BusinessInfo\":{\"Version\":\"4.3.1\"},\"LoginInfo\":{\"Source\":\"商旅APP_Android\",\"UserName\":\"tester001\"}}"}
    @FormUrlEncoded
    @POST("GetLowPriceFlightList")
    Observable<String> lowPrice(@Field("requestXml") String body) ;

    @GET("GetLowPriceFlightList")
    Observable<String> lowPrice2(@Query("requestXml") String body) ;
}
