package com.hulai.dushuren.ui.ada;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.hulai.dushuren.R;
import com.hulai.dushuren.base.MyApplication;
import com.hulai.dushuren.mvp.model.bean.LectureBean;
import com.hulai.dushuren.net.API;

import java.util.List;

/**
 * 作者:shiyuzhe on 2018/7/20 17:05
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class AdapterFrag4 extends RecyclerView.Adapter<AdapterFrag4.MyViewHolder> {


    private Context context;
    private List<LectureBean> list;

    public AdapterFrag4(Context context, List<LectureBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(list.get(position).getLecturebrief());
        Glide.with(MyApplication.getmContext())
                .load("http://101.200.176.150/bookmov/BookImage?id=1725402139")
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
        }
    }
}
