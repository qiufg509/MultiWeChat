package com.cloudservice.multiwechat.net;

import com.cloudservice.multiwechat.net.api.CloudServiceApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 网络请求controller
 * <p>
 * 网络请求步骤 见{@link CloudServiceApi}
 * <p>
 * 一个服务器地址对应一个api
 * 调用不同服务器接口需要在此对应api获取方法
 */

class HttpClient {

    private CloudServiceApi mCloudServiceApi;

    private final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new HttpLogInterceptor(HttpClient.class.getSimpleName()))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    /**
     * 获取网络请求接口
     *
     * @return 上传数据结果 {@link CloudServiceApi}
     */
    CloudServiceApi getCloudServiceApi() {
        if (mCloudServiceApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(CloudServiceUrls.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            mCloudServiceApi = retrofit.create(CloudServiceApi.class);
        }
        return mCloudServiceApi;
    }
}
