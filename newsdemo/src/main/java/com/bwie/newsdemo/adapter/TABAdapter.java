package com.bwie.newsdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */

public class TABAdapter extends FragmentStatePagerAdapter {
    private final FragmentManager fm;
    private final List<Fragment> list1;
    private final String[] mTitles;

    public TABAdapter(FragmentManager fm, List<Fragment> list1, String[] mTitles) {
        super(fm);
        this.fm = fm;
        this.list1 = list1;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list1.get(position);
    }

    @Override
    public int getCount() {
        return list1.size();
    }
}
