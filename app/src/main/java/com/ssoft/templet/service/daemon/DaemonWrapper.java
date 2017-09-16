package com.ssoft.templet.service.daemon;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/8/29 0029.
 */

public class DaemonWrapper {
    private static Activity mActivity = null;
    private static int LEVEL = 0;
    private static final int WHITE_LEVEL = 1;
    private static final int GRAY_LEVEL = 2;
    private static final int BLACK_LEVEL = 3;
    private static final int BACKGROUND_LEVEL = 4;
    private final static String BLACK_WAKE_ACTION = "com.wake.black";


    private DaemonWrapper(){

    }
    public static void bindActivity(Activity activity){
        bindActivity(activity,0);
    }
    public static void bindActivity(Activity activity,int level){
        mActivity = activity;
        LEVEL = level;
        startService();
    }

    private static void startService() {
        if (mActivity != null){
            switch (LEVEL){
                case 0:
                    Intent whiteIntent0 = new Intent(mActivity.getApplicationContext(), WhiteService.class);
                    mActivity.startService(whiteIntent0);
                    Intent grayIntent0 = new Intent(mActivity.getApplicationContext(), GrayService.class);
                    mActivity.startService(grayIntent0);
                    Intent blackIntent0 = new Intent();
                    blackIntent0.setAction(BLACK_WAKE_ACTION);
                    mActivity.sendBroadcast(blackIntent0);
                    Intent bgIntent0 = new Intent(mActivity.getApplicationContext(), BackgroundService.class);
                    mActivity.startService(bgIntent0);
                    break;
                case 1:
                    Intent whiteIntent = new Intent(mActivity.getApplicationContext(), WhiteService.class);
                    mActivity.startService(whiteIntent);
                    break;
                case 2:
                    Intent grayIntent = new Intent(mActivity.getApplicationContext(), GrayService.class);
                    mActivity.startService(grayIntent);
                    break;
                case 3:
                    Intent blackIntent = new Intent();
                    blackIntent.setAction(BLACK_WAKE_ACTION);
                    mActivity.sendBroadcast(blackIntent);
                    break;
                case 4:
                    Intent bgIntent = new Intent(mActivity.getApplicationContext(), BackgroundService.class);
                    mActivity.startService(bgIntent);
                    break;

            }

        }
    }
}
