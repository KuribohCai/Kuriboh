package com.studio.cai.mysuperdemo.rxjava_retrofit;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public interface ZhuangBiApi {
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
