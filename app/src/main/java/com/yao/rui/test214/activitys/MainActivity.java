package com.yao.rui.test214.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yao.rui.test214.R;
import com.yao.rui.test214.adapters.ViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rny on 2017/2/14.
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.vp)
    ViewPager vp;
    private List<Object> holders=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        crateViewData(6);
        vp.setAdapter(new ViewPageAdapter(holders));
    }


    private void crateViewData(int viewNum){
        for (int i =0;i<viewNum;i++){
            TextView tv=new TextView(this);
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tv.setText("添加TV"+i);
            tv.measure(60,40);
            tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//            tv.setGravity(Gravity.TOP);
            holders.add(tv);
        }
    }

    //创建数据
    private void createData(int dataNum) {
        for (int i=0;i<dataNum;i++){
            holders.add(createHolder("界面："+i));
        }
    }

    //创建Holder
    private MainBaseHolder createHolder(String s){
        View view= LayoutInflater.from(this).inflate(R.layout.item_vp_layout,null);
        return new MainBaseHolder(view,s);
    }


    //定义Holder
    class MainBaseHolder extends ViewPageAdapter.BaseHolder {

         String data;
        @BindView(R.id.con_tv)
        TextView tv;

        public MainBaseHolder(View root, String data) {
            super(root);
            this.data = data;
            //绑定数据
            tv.setText(data);
        }
    }

}
