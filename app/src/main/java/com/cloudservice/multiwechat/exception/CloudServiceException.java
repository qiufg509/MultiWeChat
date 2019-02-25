package com.cloudservice.multiwechat.exception;

/**
 * Created by fengguang.qiu on 2019/1/24.
 */

public class CloudServiceException extends Exception {

    private int errorCode;

    CloudServiceException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
        setErrorCode(resultCode);
    }

    CloudServiceException(String detailMessage) {
        super(detailMessage);
        setErrorCode(CloudServiceCode.CODE_OTHER);
    }

    public int getErrorCode() {
        return errorCode;
    }

    private void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code 错误码
     * @return 自定义错误信息
     */
    private static String getApiExceptionMessage(int code) {
        String message;
        switch (code) {
            case CloudServiceCode.CODE_TOKEN_INVALID:
                message = "登录信息失效";
                break;
            case CloudServiceCode.CODE_TIME_OUT:
                message = "连接超时";
                break;
            case CloudServiceCode.CODE_HTTP_ERROR:
                message = "网络错误";
                break;
            case CloudServiceCode.CODE_CONNECT_FAIL:
                message = "无法连接到服务器";
                break;
            case CloudServiceCode.CODE_SERVER_ERROR:
                message = "服务器异常";
                break;
            case CloudServiceCode.CODE_PARSE_ERROR:
                message = "解析错误";
                break;
            case CloudServiceCode.CODE_OPEN_CAMERA_FAIL:
                message = "打开照相机失败";
                break;
            default:
                message = "未知错误";
        }
        return message;
    }
}
