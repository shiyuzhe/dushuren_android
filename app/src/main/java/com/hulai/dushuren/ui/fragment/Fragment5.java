package com.hulai.dushuren.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseFragment;

import butterknife.BindView;


/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment5  extends BaseFragment {


    @BindView(R.id.titile)
    TextView textView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_fragment1;
    }

    @Override
    protected void bindView() {
        textView.setText("5");
    }
}
