package com.hulai.dushuren.ui.activity;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hulai.dushuren.R;
import com.hulai.dushuren.utils.ScrollTextView;
import com.hulai.dushuren.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ActView extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.textView2)
    ScrollTextView textView2;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.act_view;
    }

    boolean isCompute = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void bindView() {
        setDate();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                VelocityTracker velocityTracker = VelocityTracker.obtain();
                velocityTracker.addMovement(event);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isCompute = false;
                        Log.e("syz", "x,y::" + event.getX() + "_" + event.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!isCompute) {
                            isCompute = true;
                            velocityTracker.computeCurrentVelocity(1000);
                            float yVelocity = velocityTracker.getYVelocity();
                            Log.e("syz", "xVelocity:" + yVelocity);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        isCompute = false;
                        break;

                }
                return false;
            }
        });

//      View view = new View(this);
//        ObjectAnimator.ofFloat(view,"translationX",0,100).setDuration(1000).start();

        textView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("view","OnTouchListener:return  false");
                return false;
            }
        });

    }


    @OnClick({R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView2:
                Log.e("view","onClick");
                textView2.smoothScrollTo(-100, 0, 1000);
                break;
        }

    }

    List<String> strs = new ArrayList<>();

    private void setDate() {
        for (int i = 0; i < 20; i++) {
            strs.add("str" + i);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.item_str, parent,
                    false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.textView.setText(strs.get(position));
        }

        @Override
        public int getItemCount() {
            return strs.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            //            @BindView(R.id.textView)
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }


}
