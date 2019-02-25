package com.cloudservice.multiwechat.listener;

import java.util.Calendar;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 限定时间内只允许操作一次判断
 */

public class OneClick {

    private String methodName;
    private static final int CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    OneClick(String methodName) {
        this.methodName = methodName;
    }

    String getMethodName() {
        return methodName;
    }

    public boolean check() {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            return false;
        } else {
            return true;
        }
    }
}
