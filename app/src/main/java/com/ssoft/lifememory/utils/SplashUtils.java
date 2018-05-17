package com.ssoft.lifememory.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.ssoft.lifememory.Interface.ISplash;

/**
 *用户添加splash页面的工具类，实现了在activity之上添加一个splash类
 * 并且不影响activity的数据加载抽象成接口的方式实现
 */
public class SplashUtils {
    private static View splashView;
    private static FrameLayout rootView;
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            rootView.removeView(splashView);
            rootView = null;
            splashView = null;
            super.handleMessage(msg);
        }
    };

    /**
     * 在activity中获取layout 的id 然后显示出来
     * @param activity
     * @param iSplash
     */
    public static void init(Activity activity, ISplash iSplash, int duration) {
        int layoutId = iSplash.requestLayout();
        if (layoutId == 0) {
            return;
        }
        rootView = (FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content);
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
        handler.sendEmptyMessageDelayed(0,duration);
    }
}
