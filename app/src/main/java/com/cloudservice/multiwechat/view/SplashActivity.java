package com.cloudservice.multiwechat.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cloudservice.multiwechat.R;
import com.cloudservice.multiwechat.bean.HttpResult;
import com.cloudservice.multiwechat.exception.CloudServiceException;
import com.cloudservice.multiwechat.exception.ErrorAction;
import com.cloudservice.multiwechat.net.HttpClientImp;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        httpGet();

    }

    public void httpGet() {
        String keyword = "电脑";
        Disposable disposable = Flowable.just(keyword)
                .flatMap(new Function<String, Publisher<HttpResult>>() {
                    @Override
                    public Publisher<HttpResult> apply(String s) {
                        return HttpClientImp.getInstance().apiTest_Post(s);
                    }
                })
                .subscribe(new Subscriber() {
                }, new ErrorAction() {
                    @Override
                    public void doNext(CloudServiceException e) {
                        Logger.t(TAG).d(e.getMessage());
                    }
                });
    }

    private class Subscriber implements Consumer<HttpResult> {

        @Override
        public void accept(HttpResult httpResult) {
            Logger.t(TAG).d(httpResult.toString());
        }
    }
}
