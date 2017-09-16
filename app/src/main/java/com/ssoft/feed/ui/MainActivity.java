package com.ssoft.feed.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.ssoft.feed.R;
import com.ssoft.feed.adapter.MainPageAdapter;
import com.ssoft.feed.event.EventHelper;
import com.ssoft.feed.fragment.BaseFragment;
import com.ssoft.feed.fragment.DrinkFragment;
import com.ssoft.feed.fragment.FoodFragment;
import com.ssoft.feed.fragment.MineFragment;
import com.ssoft.feed.fragment.TravelFragment;
import com.ssoft.feed.service.daemon.DaemonWrapper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by silentlrb on 2017/8/2.
 * 主界面
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<BaseFragment> mFragments = new ArrayList<>();  //主界面显示的fragment
    private int[] mIcon = new int[]{R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 保活
        DaemonWrapper.bindActivity(this,0);
        EventHelper.register(this);
        EventHelper.post(new EventHelper.Test2Event());

        MyApplication.getRefWatcher().watch(this);



    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mTabLayout = (TabLayout) findViewById(R.id.tl_menu);
        initFragments();

        mViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(),mFragments,this));
        mTabLayout.setupWithViewPager(mViewPager);
        initIcon();
    }

    /**
     * 初始化底部菜单的icon
     */
    private void initIcon() {
        for (int i = 0;i< mTabLayout.getTabCount() && i<mIcon.length;i++){
            mTabLayout.getTabAt(i).setIcon(mIcon[i]);
        }
    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        mFragments.add(new FoodFragment());
        mFragments.add(new DrinkFragment());
        mFragments.add(new TravelFragment());
        mFragments.add(new MineFragment());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventHelper.TestEvent event) {
        Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();
        /* Do something */
    };
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventHelper.Test2Event event) {
        Toasty.info(this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
        /* Do something */
    };
}
