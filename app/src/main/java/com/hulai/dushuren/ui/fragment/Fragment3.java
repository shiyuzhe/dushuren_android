package com.hulai.dushuren.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseFragment;
import com.hulai.dushuren.ui.activity.ActRxJava;
import com.hulai.dushuren.ui.activity.ActTab;
import com.hulai.dushuren.ui.activity.ActView;
import com.hulai.dushuren.ui.activity.SecondActivity;

import butterknife.BindView;


/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment3 extends BaseFragment {


    @BindView(R.id.titile)
    TextView textView;

    private static Fragment3 instance;

    public static Fragment3 getInstance() {
        if (instance == null) {
            instance = new Fragment3();
        }
        Log.e("syz", "Fragment3");
        return instance;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_fragment1;
    }

    @Override
    protected void bindView() {
        textView.setText("3");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ActRxJava.class));
            }
        });
    }
}
