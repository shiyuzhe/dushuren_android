package com.hulai.dushuren.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.hulai.dushuren.R;
import com.hulai.dushuren.ui.ada.MyTabFragmentPagerAdapter;
import com.hulai.dushuren.base.BaseFragment;
import com.hulai.dushuren.utils.MyTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class Fragment1 extends BaseFragment {


    private static Fragment1 instance;
    public static Fragment1 getInstance() {
        if (instance == null) {
            instance = new Fragment1();
        }
        Log.e("syz","Fragment1");
        return instance;
    }


    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    MyTabLayout mTabLayout;
    MyTabFragmentPagerAdapter mMyTabFragmentPagerAdapter;
    private List<Fragment> fragments;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_video;
    }

    @Override
    protected void bindView() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment2());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());


        mMyTabFragmentPagerAdapter = new MyTabFragmentPagerAdapter(getActivity().getSupportFragmentManager()
                , fragments);
        mViewPager.setOffscreenPageLimit(fragments.size() - 1 > 0 ? fragments.size() - 1 : 1);
        mViewPager.setAdapter(mMyTabFragmentPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方
        List<String> str = new ArrayList<>();
        str.add("推荐");
        str.add("圆桌");
        str.add("热门");
        str.add("收藏");
        mTabLayout.setTitle(str);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabLayout.setScrollPosition(position, positionOffset, false);
            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = mTabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        mTabLayout.setupWithViewPager(mViewPager);
    }
}
