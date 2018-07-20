package com.hulai.dushuren.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * 作者:shiyuzhe on 2018/7/9 15:36
 * 邮箱:18091664559@163.com
 * Desc:延迟动画
 */
@SuppressLint("AppCompatCustomView")
public class ScrollTextView extends TextView {
    Scroller mScroller;

    public ScrollTextView(Context context) {
        super(context);
        mScroller = new Scroller(context);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public ScrollTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }


    public void smoothScrollTo(int dx, int dy, int duration) {
        //设置滑动参数
        mScroller.startScroll(getScrollX(), getScrollY(), dx, dy, duration);
        //重新绘制View
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("view","onTouchEvent:ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("view","onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("view","onTouchEvent:ACTION_UP");
                break;

        }
        Log.e("view","onTouchEvent:return  super.onTouchEvent(event)");
//        return true;
        return super.onTouchEvent(event);
    }
}
