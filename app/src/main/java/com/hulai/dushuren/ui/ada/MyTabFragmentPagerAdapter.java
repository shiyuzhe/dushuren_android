package com.hulai.dushuren.ui.ada;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者:shiyuzhe on 2018/7/2 20:54
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class MyTabFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles={"推推荐", "圆桌", "热热门", "收藏"};
    private List<Fragment> fragments;

    public MyTabFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}

