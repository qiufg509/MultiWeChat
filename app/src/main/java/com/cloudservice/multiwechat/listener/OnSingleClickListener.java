package com.cloudservice.multiwechat.listener;

import android.view.View;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 防止多次点击操作
 */

public abstract class OnSingleClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if (AntiShake.check(v.getId())) {
            return;
        }
        oneClick(v);
    }

    public abstract void oneClick(View v);
}
