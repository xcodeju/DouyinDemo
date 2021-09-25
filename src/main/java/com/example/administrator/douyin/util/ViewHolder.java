package com.example.administrator.douyin.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.administrator.douyin.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView img_thumb;
    VideoView videoView;
    ImageView img_play;
    RelativeLayout rootView;

    public ViewHolder(View itemView) {
        super(itemView);
        img_thumb = itemView.findViewById(R.id.img_thumb);
        videoView = itemView.findViewById(R.id.video_view);
        img_play = itemView.findViewById(R.id.img_play);
        rootView = itemView.findViewById(R.id.root_view);
    }
}
