package com.github.jdsjlzx.progressindicator.indicators;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;

import com.github.jdsjlzx.R;

import java.lang.ref.SoftReference;

/**
 * Created by limxing on 16/7/23.
 *
 * https://github.com/limxing
 * Blog: http://www.leefeng.me
 */
public class IOSLoadView extends android.support.v7.widget.AppCompatImageView {
    private MyRunable runnable;
    private int width;
    private int height;

    public IOSLoadView(Context context) {
        super(context);
        init();
    }

    public IOSLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IOSLoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (runnable!=null){
            runnable.stopload();
        }
        runnable = null;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        runnable = new MyRunable(this);
        if (runnable != null && !runnable.flag) {
            runnable.startload();
        }
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
        setImageBitmap(bitmap);
        width = bitmap.getWidth() / 2;
        height = bitmap.getHeight() / 2;
    }

    static class MyRunable implements Runnable {
        private boolean flag;
        private SoftReference<IOSLoadView> loadingViewSoftReference;
        private float degrees = 0f;
        private Matrix max;

        public MyRunable(IOSLoadView loadingView) {
            loadingViewSoftReference = new SoftReference<IOSLoadView>(loadingView);
            max = new Matrix();
        }

        @Override
        public void run() {
            if (loadingViewSoftReference.get().runnable != null && max != null) {
                degrees += 30f;
                max.setRotate(degrees, loadingViewSoftReference.get().width, loadingViewSoftReference.get().height);
                loadingViewSoftReference.get().setImageMatrix(max);
                if (degrees == 360) {
                    degrees = 0;
                }
                if (flag) {
                    loadingViewSoftReference.get().postDelayed(loadingViewSoftReference.get().runnable, 100);
                }
            }
        }

        public void stopload() {
            flag = false;
        }

        public void startload() {
            flag = true;
            if (loadingViewSoftReference.get().runnable != null && max != null) {
                loadingViewSoftReference.get().postDelayed(loadingViewSoftReference.get().runnable, 100);
            }
        }
    }
}