package com.cloudservice.multiwechat;

import android.app.Application;
import android.os.Build;

import com.orhanobut.logger.HampooLogConfig;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.adapter.AndroidLogAdapter;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String category = "SK12";
        String project = getString(getApplicationInfo().labelRes);
        String type = "device";
        String id = Build.SERIAL;

        HampooLogConfig.Builder builder = new HampooLogConfig.Builder(this)
                //.host(host)//默认 http://192.168.5.118
                //.logCacheFolder(appContext.getExternalCacheDir().getAbsolutePath())//默认 appContext.getExternalCacheDir()/logger目录
                .category(category)
                .project(project)
                .addLogProfile(AndroidLogAdapter.class.getName(), 2)
                .type(type)
                .id(id);
        Logger.init(this, builder.build());
    }
}
