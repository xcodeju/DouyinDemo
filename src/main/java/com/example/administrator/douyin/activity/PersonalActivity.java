package com.example.administrator.douyin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.douyin.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        blurBackGround();
    }

    /**
     * 模糊背景实现
     * */
    private void blurBackGround(){
        ImageView mBgImage = findViewById(R.id.iv_bg);
        //背景模糊实现
        Glide.with(PersonalActivity.this).load(R.mipmap.bg_blure).bitmapTransform(new BlurTransformation(PersonalActivity.this,20,2))
                .into(mBgImage);
    }
}