package com.cloudservice.multiwechat.exception;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 会议系统请求响应码
 */

public interface CloudServiceCode {

    /**
     * 网络请求成功
     */
    int CODE_RESPONSE_SUCCESS = 200;
    int CODE_TOKEN_INVALID = 999;
    int CODE_TIME_OUT = 45401;
    int CODE_CONNECT_FAIL = 45402;
    int CODE_SERVER_ERROR = 45403;
    int CODE_HTTP_ERROR = 45404;
    int CODE_PARSE_ERROR = 45405;
    int CODE_SCAN_WIFI_EMPTY = 45406;
    int CODE_OPEN_CAMERA_FAIL = 45408;
    int CODE_USB_NOT_FOUND = 45409;
    int CODE_USB_CANNOT_READ_WRITE = 45410;


    int CODE_OTHER = 45499;
    //read me：因为后台接口错误码定义多有重复重叠，不方便全局定义其余错误码
}
