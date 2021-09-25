package com.example.administrator.douyin.activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.douyin.util.MyAdapter;
import com.example.administrator.douyin.manager.MyLayoutManager2;
import com.example.administrator.douyin.util.OnViewPagerListener;
import com.example.administrator.douyin.manager.PlayVideoManager;
import com.example.administrator.douyin.R;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "DouYin";
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    MyLayoutManager2 myLayoutManager;
    //我的界面按钮
    private TextView mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initEvent();
        hideBottomUIMenu();
    }

    /**
     * 初始化控件
     */

    private void initView() {

        mRecyclerView = findViewById(R.id.recycler);
        myLayoutManager = new MyLayoutManager2(this, OrientationHelper.VERTICAL, false);

        mAdapter = new MyAdapter(this);
        mRecyclerView.setLayoutManager(myLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mHome = findViewById(R.id.me);

    }

    /**
     * 实现滑动监听
     */
    private void initListener() {
        myLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                Log.e(TAG, "释放位置:" + position + " 下一页:" + isNext);
                int index = 0;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                PlayVideoManager.getInstance(mRecyclerView).releaseVideo(index);
            }

            @Override
            public void onPageSelected(int position, boolean bottom) {
                Log.e(TAG, "选择位置:" + position + " 下一页:" + bottom);

                PlayVideoManager.getInstance(mRecyclerView).playVideo(0);
            }
        });
    }

    /**
     * 设置点击事件
     * */
    private void initEvent(){
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PersonalActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 隐藏底部导航栏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            Window window = getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
            window.setAttributes(params);
        }
    }


}