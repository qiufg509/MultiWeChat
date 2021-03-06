package com.cloudservice.multiwechat.net;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * 网络请求拦截
 * <p>
 * HttpLogInterceptor
 */
public class HttpLogInterceptor implements Interceptor {

    private String mTag = HttpLogInterceptor.class.getSimpleName();
    private boolean showResponse;

    private long startTimeMillis = 0;
    private long endTimeMillis = 0;

    /**
     * 构造函数
     *
     * @param tag          TAG
     * @param showResponse 是否将response打印出来
     */
    public HttpLogInterceptor(String tag, boolean showResponse) {
        if (TextUtils.isEmpty(tag)) {
            tag = HttpLogInterceptor.class.getSimpleName();
        }
        this.showResponse = showResponse;
        this.mTag = tag;
    }

    /**
     * 构造函数<br>
     * 默认会将response打印出来
     *
     * @param tag TAG
     */
    public HttpLogInterceptor(String tag) {
        this(tag, true);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        startTimeMillis = System.currentTimeMillis();
        Request request = chain.request();
        logRequest(request);

        Response response = chain.proceed(request);
        endTimeMillis = System.currentTimeMillis();

        return logResponse(response);
    }

    private void logRequest(Request request) {
        try {
            String requestStr = URLDecoder.decode(request.toString());
            String headers = headerToString(request.headers());
            String contentType = "unknown";
            String body = null;

            RequestBody requestBody = request.body();
            if (requestBody != null) {
                MediaType mediaType = requestBody.contentType();
                if (mediaType != null) {
                    contentType = mediaType.toString();
                    if (isText(mediaType)) {
                        body = bodyToString(request);
                    } else {
                        body = "requestBody maybe [file part] , too large too print , ignored!";
                    }
                }
            }

            Logger.t(mTag).i("========request======>>>" + "\n"
                    + "requestStr:" + requestStr + "\n"
                    + "contentType:" + contentType + "\n"
                    + "requestBody:" + body + "\n"
                    + "requestHeaders:" + headers + "\n"
                    + "========request end========="
            );


        } catch (Exception e) {
            Logger.t(mTag).i("Exception e:" + e.getMessage());
        }
    }

    private Response logResponse(Response response) {
        if (!showResponse) {
            Logger.t(mTag).i("showResponse:" + showResponse + ", will not log the response");
            return response;
        }

        Response.Builder builder = response.newBuilder();

        try {
            String responseStr = URLDecoder.decode(response.toString());
            String contentType = "unknown";
            String headers = headerToString(response.headers());
            String body = null;

            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                MediaType mediaType = responseBody.contentType();
                if (mediaType != null) {
                    contentType = mediaType.toString();
                    if (isText(mediaType)) {
                        body = responseBody.string();
                        builder.body(ResponseBody.create(mediaType, body));
                    } else {
                        body = "requestBody maybe [file part] , too large too print , ignored!";
                    }
                }
            }

            Logger.t(mTag).i("<<<=====response=========" + "\n"
                    + "responseStr:" + responseStr + "\n"
                    + "contentType:" + contentType + "\n"
                    + "responseHeaders:" + headers + "\n"
                    + "responseBody:" + body + "\n"
                    + "startTimeMillis:" + startTimeMillis + ", endTimeMillis:" + endTimeMillis
                    + ", take:" + (endTimeMillis - startTimeMillis) + "\n"
                    + "========response end========="
            );

        } catch (Exception e) {
            Logger.t(mTag).i("Exception e:" + e.getMessage());
        }
        return builder.build();
    }

    private boolean isText(MediaType mediaType) {
        return mediaType.type() != null && mediaType.type().equals("text")
                || mediaType.subtype() != null && (mediaType.subtype().equals("json")
                || mediaType.subtype().equals("xml")
                || mediaType.subtype().equals("html")
                || mediaType.subtype().equals("webviewhtml")
                || mediaType.subtype().equals("x-www-form-urlencoded"));
    }

    /**
     * 将request body拼接成String，如："platform=android&version=1.0.1&login_pass=123456&login_name=aaa108"
     */
    private String bodyToString(Request request) {
        try {
            Request copyRequest = request.newBuilder().build();
            RequestBody requestBody = copyRequest.body();
            if (requestBody == null) {
                return null;
            }
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            String body = buffer.readUtf8();

            return URLDecoder.decode(body);

        } catch (final IOException e) {
            return "something error, e:" + e.getMessage();
        }
    }

    /**
     * 将header拼接成String，如："User-Agent: mvp, Cache-Control: no-cache"
     */
    private String headerToString(Headers headers) {
        if (headers == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0, size = headers.size(); i < size; i++) {
            result.append(headers.name(i)).append(":").append(headers.value(i)).append(", ");
        }
        return result.toString();
    }
}
