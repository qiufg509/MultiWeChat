package com.cloudservice.multiwechat.bus;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * RxJava2线程切换
 */

public class RxSchedulers {

    /**
     * 流线程切换（io线程/主线程）
     *
     * @param <T> Observable操作的数据类型
     * @return Observable
     */
    public static <T> FlowableTransformer<T, T> ioSchedulers() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 流线程切换（事件循环或和回调处理线程/主线程）
     *
     * @param <T> Observable操作的数据类型
     * @return Observable
     */
    public static <T> FlowableTransformer<T, T> normalSchedulers() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
