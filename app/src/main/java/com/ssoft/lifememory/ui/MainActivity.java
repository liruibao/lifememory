package com.ssoft.lifememory.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.ssoft.lifememory.Interface.ISplash;
import com.ssoft.lifememory.R;
import com.ssoft.lifememory.adapter.MainPageAdapter;
import com.ssoft.lifememory.base.BaseActivity;
import com.ssoft.lifememory.base.BaseFragment;
import com.ssoft.lifememory.modules.drink.DrinkFragment;
import com.ssoft.lifememory.modules.food.FoodFragment;
import com.ssoft.lifememory.modules.mine.MineFragment;
import com.ssoft.lifememory.modules.travel.TravelFragment;
import com.ssoft.lifememory.utils.SplashUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silentlrb on 2017/8/2.
 * 主界面
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MainPageAdapter mPageAdapter;
    private List<BaseFragment> mFragments = new ArrayList<>();  //主界面显示的fragment



    @Override
    public int requestLayout() {

        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        SplashUtils.init(this, new ISplash() {
            @Override
            public int requestLayout() {
                return R.layout.layout_splash;
            }
        },3000);
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        mTabLayout = (TabLayout) findViewById(R.id.tl_menu);
        initFragments();

        mPageAdapter = new MainPageAdapter(getSupportFragmentManager(),mFragments,this);
        mViewPager.setAdapter(mPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        initIcon();

    }

    /**
     * 初始化底部菜单的icon
     */
    private void initIcon() {
        for (int i = 0;i< mTabLayout.getTabCount() && i<mFragments.size();i++){
            mTabLayout.getTabAt(i).setCustomView(mPageAdapter.getTabView(i));
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

}
