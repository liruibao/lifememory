package com.ssoft.lifememory.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ssoft.lifememory.service.daemon.DaemonWrapper;
import com.ssoft.lifememory.ui.MyApplication;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * Created by silentlrb on 2017/8/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private static final String TAG = BaseActivity.class.getName();
    private boolean mIsDamonStart = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        init();
        initTheme();

        setContentView(requestLayout());
        ButterKnife.bind(this);
        initInjector();
        initView();
        initListener();
        initData();
        initDamonService();

        //内存泄漏
        MyApplication.getRefWatcher().watch(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(mContext);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(mContext);
    }


    public void showToast(String text) {
        if (text != null && !text.trim().equals("")) {
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 设置布局前的初始化
     */
    public void init() {
    }

    /**
     * 初始化主题
     */
    public void initTheme() {
    }

    /**
     * 布局
     *
     * @return
     */
    public abstract int requestLayout();

    /**
     * View需要初始化的
     */
    public void initView() {
    }

    /**
     * 初始化注入
     */
    public void initInjector() {
    }

    /**
     * 初始化监听器
     */
    public void initListener() {
    }

    /**
     * 初始化数据
     */
    public void initData() {
    }

    /**
     * 初始化保活
     */
    public void initDamonService() {
        // 保活
        if (!mIsDamonStart) {
            DaemonWrapper.bindActivity(getApplicationContext(), 0);

            mIsDamonStart = true;
        }

    }


}
