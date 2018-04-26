package com.ssoft.lifememory.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.ssoft.lifememory.Interface.ISplash;

public class SplashUtils {
    private static View splashView;
    private static FrameLayout rootView;
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            rootView.removeView(splashView);
            super.handleMessage(msg);
        }
    };

    public static void init(Activity activity, ISplash iSplash) {
        int layoutId = iSplash.requestLayout();
        if (layoutId == 0) {
            return;
        }
        rootView = (FrameLayout) activity.getWindow().getDecorView();
        splashView = LayoutInflater.from(activity).inflate(layoutId, null, false);
        FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        splashView.setLayoutParams(p);
        rootView.addView(splashView);
        splashView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        handler.sendEmptyMessageDelayed(0,3000);
    }
}
