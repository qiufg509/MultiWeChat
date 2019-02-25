package com.cloudservice.multiwechat;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cloudservice.multiwechat.bean.HttpResult;
import com.cloudservice.multiwechat.exception.CloudServiceException;
import com.cloudservice.multiwechat.exception.ErrorAction;
import com.cloudservice.multiwechat.net.HttpClientImp;
import com.orhanobut.logger.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String TAG = ExampleInstrumentedTest.class.getSimpleName();

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cloudservice.multiwechat", appContext.getPackageName());
    }

    /**
     * disposable需要适当的时候release，如页面销毁时
     * if(disposable != null && !disposable.isDisposed()){disposable.dispose();}
     */
    @Test
    public void httpPost() {
        String keyword = "电脑";
        Disposable disposable = Flowable.just(keyword)
                .flatMap(new Function<String, Publisher<HttpResult>>() {
                    @Override
                    public Publisher<HttpResult> apply(String s) {
                        return HttpClientImp.getInstance().apiTest_Post(s);
                    }
                })
                .subscribe(new ExampleInstrumentedTest.Subscriber() {
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
