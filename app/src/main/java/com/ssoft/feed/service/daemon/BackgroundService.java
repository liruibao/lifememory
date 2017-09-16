package com.ssoft.feed.service.daemon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.ssoft.feed.utils.LogHelper;

/**
 * 普通的后台Service进程
 *
 *  Created by silentlrb on 2017/8/2.
 */
public class BackgroundService extends Service {

    private final static String TAG = BackgroundService.class.getSimpleName();

    @Override
    public void onCreate() {
        LogHelper.i(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        LogHelper.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
