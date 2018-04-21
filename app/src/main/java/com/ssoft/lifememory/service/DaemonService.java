package com.ssoft.lifememory.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/8/4.
 */

public class DaemonService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Notification n = createNotification(getApplicationContext());
//        if (n != null) {
//            startForeground(GRAY_SERVICE_ID, n);
//        }
//        stopForeground(true);
//        stopSelf();
//        return super.onStartCommand(intent, flags, startId);
//    }

//    public Notification createNotification(Context context){
////        隐藏的notifications
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(context);
//        if (context.getApplicationContext().getResources().getDrawable(R.drawable.durec_gray_service_noti_icon) != null) {
//            builder.setSmallIcon(R.drawable.durec_gray_service_noti_icon);
//        } else {
//            int appIcon = context.getApplicationInfo().icon;
//            if (context.getApplicationContext().getResources().getDrawable(appIcon) != null) {
//                builder.setSmallIcon(appIcon);
//            } else {
//                return null;
//            }
//        }
//
//        builder.setContentTitle(context.getString(R.string.app_name));
//        Intent contentIntent = new Intent(context, AppActivity.class);
//        contentIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        builder.setContentIntent(PendingIntent.getActivity(context, 0, contentIntent,
//                PendingIntent.FLAG_ONE_SHOT));
//        Notification foregroundNoti = builder.build();
//        foregroundNoti.icon = R.drawable.notification_icon;
//        return foregroundNoti;
//    }




}
