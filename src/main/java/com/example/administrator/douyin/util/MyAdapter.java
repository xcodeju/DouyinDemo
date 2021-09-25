package com.example.administrator.douyin.util;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.douyin.R;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int[] imgs = {R.mipmap.img_video_1, R.mipmap.img_video_2, R.mipmap.img_video_3, R.mipmap.img_video_4, R.mipmap.img_video_5, R.mipmap.img_video_6, R.mipmap.img_video_7, R.mipmap.img_video_8};
    private int[] videos = {R.raw.video_1, R.raw.video_2, R.raw.video_3, R.raw.video_4, R.raw.video_5, R.raw.video_6, R.raw.video_7, R.raw.video_8};
    private int index = 0;
    private Context mContext;

    public MyAdapter(Context context) {
        this.mContext = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img_thumb.setImageResource(imgs[index]);
        holder.videoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[index]));
        index++;
        if (index >= 7) {
            index = 0;
        }
    }

    @Override
    public int getItemCount() {
        return videos.length;
    }
}
