package com.ssoft.lifememory.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssoft.lifememory.R;
import com.ssoft.lifememory.base.BaseFragment;

import java.util.List;

/**
 * Created by silentlrb on 2017/7/30.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragments;
    private Context mContext;
    private String[] mTitles = new String[]{"美文", "美音", "美图", "美视"};
    private int[] icons = new int[]{R.drawable.tab_text_selector, R.drawable.tab_voice_selector,
            R.drawable.tab_photo_selector, R.drawable.tab_video_selector};

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

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
        ImageView imgView = view.findViewById(R.id.img);
        imgView.setBackgroundResource(icons[position]);
        TextView txView = view.findViewById(R.id.tx);
        txView.setText(mTitles[position]);
        return view;


    }


}
