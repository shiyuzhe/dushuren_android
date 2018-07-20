package com.hulai.dushuren.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者:shiyuzhe on 2018/7/2 17:33
 * 邮箱:18091664559@163.com
 * Desc:不能左右滑动的viewpager
 */
public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //表示事件是否拦截，返回false表示不拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    //重写onTouchEvent事件，什么都不用做

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
