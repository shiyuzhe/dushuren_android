package com.hulai.dushuren.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hulai.dushuren.R;
import com.hulai.dushuren.utils.MyTabLayout;

import java.util.Arrays;
import java.util.List;

public class ActTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tab);
        String[] str = {"zhang", "phil", "zhang phil", "csdn", "zhang phil csdn", "zhang phil @ csdn", "blog.csdn.net/zhangphil", "android"};

        List<String> titles = Arrays.asList(str);

        MyTabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTitle(titles);

    }
}
