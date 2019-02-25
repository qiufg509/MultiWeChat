package com.cloudservice.multiwechat.listener;

import com.cloudservice.multiwechat.bean.LimitQueue;

import java.util.ArrayList;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 点击防抖动
 */

public class AntiShake {

    private static LimitQueue<OneClick> queue = new LimitQueue<>(20);

    public static boolean check(Object o) {
        String flag = o == null ? Thread.currentThread().getStackTrace()[2].getMethodName() : o.toString();
        ArrayList<OneClick> list = queue.getArrayList();
        for (OneClick oneClick : list) {
            if (oneClick.getMethodName().equals(flag)) {
                return oneClick.check();
            }
        }
        OneClick oneClick = new OneClick(flag);
        queue.offer(oneClick);
        return oneClick.check();
    }

    public static boolean check() {
        return check(null);
    }
}
