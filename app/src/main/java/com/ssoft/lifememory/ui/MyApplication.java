package com.ssoft.lifememory.ui;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.ssoft.lifememory.BuildConfig;
import com.ssoft.lifememory.utils.CrashHandler;
import com.ssoft.lifememory.utils.LogHelper;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MyApplication extends Application {


    public static RefWatcher refWatcher = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //判断是否打印日志
        if (BuildConfig.LOG_DEBUG == true) {
            LogHelper.init(true);
        } else {
            LogHelper.init(false);
        }

        //全局处理异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
        // 内存泄漏检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
        // Normal app init code...
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

}
