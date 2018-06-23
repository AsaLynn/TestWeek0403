package com.hankkin.compustrading.test.http;

import com.hankkin.compustrading.test.bean.ImageInfo;
import com.hankkin.compustrading.test.bean.ProductInfo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by think on 2018/3/20.
 */

public interface RetrofitServer {

    @GET()
    Call<List<ProductInfo>> getProductInfos(@Url String url);

    @GET()
    Call<ResponseBody> getProductInfosBody(@Url String url);

    @GET()
    Call<ImageInfo> getImageInfo(@Url String url);
}
