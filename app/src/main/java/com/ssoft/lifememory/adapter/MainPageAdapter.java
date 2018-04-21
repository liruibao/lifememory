package com.ssoft.lifememory.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ssoft.lifememory.base.BaseFragment;

import java.util.List;

/**
 * Created by silentlrb on 2017/7/30.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragments;
    private Context mContext;
    private String[] mTitles = new String[]{"美食", "美酒", "美景","我的"};

    public MainPageAdapter(FragmentManager fm, List<BaseFragment> fragments, Context context) {
        super(fm);
        this.mFragmentManager = fm;
        this.mFragments = fragments;
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }




}
