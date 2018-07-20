package com.hulai.dushuren.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseFragment;
import com.hulai.dushuren.mvp.model.bean.LectureBean;
import com.hulai.dushuren.ui.ada.AdapterFrag4;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment4 extends BaseFragment {


    @BindView(R.id.lrv)
    LRecyclerView lrv;
    LRecyclerViewAdapter adapter;
    AdapterFrag4 adapterFrag4;
    List<LectureBean> list;


    private static Fragment4 instance;

    public static Fragment4 getInstance() {
        if (instance == null) {
            instance = new Fragment4();
        }
        Log.e("syz", "Fragment4");
        return instance;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_fragment4;
    }

    @Override
    protected void bindView() {
        initDate();
        adapterFrag4 = new AdapterFrag4(getActivity(), list);
        adapter = new LRecyclerViewAdapter(adapterFrag4);
        lrv.setAdapter(adapter);
        lrv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        lrv.setLoadMoreEnabled(false);
        lrv.setPullRefreshEnabled(false);
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new LectureBean(i + "", "content" + i));
        }
    }

}
