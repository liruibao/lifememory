package com.ssoft.lifememory.modules.travel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssoft.lifememory.R;
import com.ssoft.lifememory.base.BaseFragment;

/**
 * Created by silentlrb on 2017/7/31.
 */

public class TravelFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_travel,container,false);
    }
}
