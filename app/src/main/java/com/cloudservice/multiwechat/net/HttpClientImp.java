package com.cloudservice.multiwechat.net;

import com.cloudservice.multiwechat.bean.HttpResult;
import com.cloudservice.multiwechat.bus.RxSchedulers;
import com.cloudservice.multiwechat.net.api.CloudServiceApi;

import io.reactivex.Flowable;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * HttpClient
 * 网络请求步骤 见{@link CloudServiceApi}
 */

public class HttpClientImp extends HttpClient {

    private static HttpClientImp sHttpClient;

    private HttpClientImp() {
    }

    public static HttpClientImp getInstance() {
        if (sHttpClient == null) {
            synchronized (HttpClientImp.class) {
                if (sHttpClient == null) {
                    sHttpClient = new HttpClientImp();
                }
            }
        }
        return sHttpClient;
    }

    public Flowable<HttpResult> apiTest_Post(String bk_key) {
        return sHttpClient.getCloudServiceApi()
                .apiTest_Post(CloudServiceApi.t_scope, CloudServiceApi.t_format,
                        CloudServiceApi.t_appid, bk_key, CloudServiceApi.t_bk_length)
                .compose(RxSchedulers.<HttpResult>ioSchedulers());
    }
}