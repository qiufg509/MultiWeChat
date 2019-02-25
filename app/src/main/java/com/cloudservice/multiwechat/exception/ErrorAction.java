package com.cloudservice.multiwechat.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 错误动作
 */

public class ErrorAction implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) {
        CloudServiceException exception;
        String message = throwable.getMessage() == null ? throwable.toString() : throwable.getMessage();
        if (throwable instanceof CloudServiceException) {
            exception = (CloudServiceException) throwable;
        } else if (throwable instanceof SocketTimeoutException) {
            exception = new CloudServiceException(CloudServiceCode.CODE_TIME_OUT);
        } else if (throwable instanceof HttpException) {
            exception = new CloudServiceException(CloudServiceCode.CODE_HTTP_ERROR);
        } else if (throwable instanceof ConnectException) {
            exception = new CloudServiceException(CloudServiceCode.CODE_CONNECT_FAIL);
        } else if (throwable instanceof JsonParseException
                || throwable instanceof ParseException
                || throwable instanceof JSONException) {
            exception = new CloudServiceException(CloudServiceCode.CODE_PARSE_ERROR);
        } else if (throwable instanceof UnknownHostException
                || throwable instanceof NoRouteToHostException
                || throwable instanceof UnknownServiceException) {
            exception = new CloudServiceException(CloudServiceCode.CODE_SERVER_ERROR);
        } else {
            exception = new CloudServiceException(message);

        }
        Logger.w("throwable.getMessage() = " + message);
        doNext(exception);
    }

    public void doNext(CloudServiceException e) {
    }
}
