package com.hulai.dushuren.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseActivity;
import com.hulai.dushuren.mvp.model.bean.Teacher;
import com.hulai.dushuren.ui.fragment.Fragment1;
import com.hulai.dushuren.ui.fragment.Fragment2;
import com.hulai.dushuren.ui.fragment.Fragment3;
import com.hulai.dushuren.ui.fragment.Fragment4;

import javax.inject.Inject;

import butterknife.BindView;

public class ActHome extends BaseActivity {

    @BindView(R.id.rg_group)
    RadioGroup rgGroup;
    @BindView(R.id.top_main)
    View topMain;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    @Inject
    Teacher teacher;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.act_home;
    }

    @Override
    protected void bindView() {
        switchFragment(0);
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_home) {
                    switchFragment(0);
                    topMain.setVisibility(View.VISIBLE);
                } else if (i == R.id.rb_news) {
                    switchFragment(1);
                    topMain.setVisibility(View.VISIBLE);
                } else if (i == R.id.rb_service) {
                    switchFragment(2);
                    topMain.setVisibility(View.VISIBLE);
                } else if (i == R.id.rb_gov) {
                    switchFragment(3);
                    topMain.setVisibility(View.GONE);
                }
            }
        });
    }


    private void switchFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (fragment1 != null) {
                    transaction.show(fragment1);
                } else {
                    fragment1 = Fragment1.getInstance();
                    transaction.add(R.id.fl_content, fragment1, "1");
                }
                break;
            case 1:
                if (fragment2 != null) {
                    transaction.show(fragment2);
                } else {
                    fragment2 = Fragment2.getInstance();
                    transaction.add(R.id.fl_content, fragment2, "2");
                }
                break;
            case 2:
                if (fragment3 != null) {
                    transaction.show(fragment3);
                } else {
                    fragment3 = Fragment3.getInstance();
                    transaction.add(R.id.fl_content, fragment3, "3");
                }
                break;
            case 3:
                if (fragment4 != null) {
                    transaction.show(fragment4);
                } else {
                    fragment4 = Fragment4.getInstance();
                    transaction.add(R.id.fl_content, fragment4, "4");
                }
                break;
            default:
                break;

        }
        transaction.commitAllowingStateLoss();


    }

    private void hideFragment(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
        if (fragment4 != null) {
            transaction.hide(fragment4);
        }
    }


    private long mExitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime <= 2000) {
                finish();
            } else {
                mExitTime = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
