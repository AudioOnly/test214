package com.yao.rui.test214.activitys;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.yao.rui.statusbar.StatusBarUils;
import com.yao.rui.test214.R;
import com.yao.rui.test214.adapters.FragmentAdapter;
import com.yao.rui.test214.fragments.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rny on 2017/3/17.
 */

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.cursor)
    ImageView iv;

    //底部横线宽度
    private int bmpW;
    //底部横线图片的偏移量
    private int offset;
    //当前显示卡号
    private int currIndex;

    private List<Fragment> fragments;
    private List<String> titles;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
//        StatusBarUils.setTranslucentImageStatusBar(this);
        StatusBarUils.translucentStatusBar(this,findViewById(R.id.frag_ll));
        ButterKnife.bind(this);
        initImage();
        createFragments(5);
        vp.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments,titles));
        vp.setCurrentItem(0);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //连个相邻页面，page偏移量
            private int one=offset*2+bmpW;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Animation am=new TranslateAnimation(currIndex*one,position*one,0,0);
                currIndex=position;
                am.setFillAfter(true);
                am.setDuration(200);
                iv.setAnimation(am);
                int i = currIndex + 1;
                Toast.makeText(FragmentActivity.this, "您选择了第"+i+"个页卡", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        添加分支，并提交 newsBranch327类到分支中。这里只是做一个分割点来使用
    }


    //创建fragment
    private void createFragments(int fragmentNum){
        fragments=new ArrayList<>();
        titles=new ArrayList<>();
        for (int i=0;i<fragmentNum;i++){
            MyFragment fragment=MyFragment.inStance("fragment："+i);
            fragments.add(fragment);
            titles.add("title:"+i);
        }
    }

    //title 点击事件
    @OnClick({R.id.tv_guid1,R.id.tv_guid2,R.id.tv_guid3,R.id.tv_guid4,R.id.tv_guid5})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_guid1:
                vp.setCurrentItem(0);
                break;
            case R.id.tv_guid2:
                vp.setCurrentItem(1);
                break;
            case R.id.tv_guid3:
                vp.setCurrentItem(2);
                break;
            case R.id.tv_guid4:
                vp.setCurrentItem(3);
                break;
            case R.id.tv_guid5:
                vp.setCurrentItem(4);
                break;
        }
    }
    //初始化图片的位移像素
    private void initImage(){

        bmpW= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher).getWidth();
        DisplayMetrics dm=getResources().getDisplayMetrics();
//                new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW=dm.widthPixels;
        offset=(screenW/5-bmpW)/2;
        //imageview设置平移，使下划线平移到初始位置（平移一个 offset）
        Matrix mx=new Matrix();
        mx.postTranslate(offset,0);
        iv.setImageMatrix(mx);
    }




}
