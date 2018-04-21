package com.ssoft.lifememory.service.daemon;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;

import com.ssoft.lifememory.R;
import com.ssoft.lifememory.ui.MainActivity;
import com.ssoft.lifememory.utils.LogHelper;


/**
 *  Created by silentlrb on 2017/8/2.
 * 正常的系统前台进程，会在系统通知栏显示一个Notification通知图标
 *
 */
public class WhiteService extends Service {

    private final static String TAG = WhiteService.class.getSimpleName();

    private final static int FOREGROUND_ID = 1000;

    @Override
    public void onCreate() {
        LogHelper.i(TAG, "WhiteService->onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogHelper.i(TAG, "WhiteService->onStartCommand");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Foreground");
        builder.setContentText("I am a foreground service");
        builder.setContentInfo("Content Info");
        builder.setWhen(System.currentTimeMillis());
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        startForeground(FOREGROUND_ID, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        LogHelper.i(TAG, "WhiteService->onDestroy");
        super.onDestroy();
    }
}
