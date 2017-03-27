package com.yao.rui.test214.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yao.rui.test214.R;
import com.yao.rui.test214.views.MyText;

/**
 * Created by Rny on 2017/3/20.
 */

public class AutoViewActivity extends AppCompatActivity {
    private MyText tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_view);
        tv=(MyText)findViewById(R.id.my_text_v_id);
//        tv.setText_str("测试数据");
    }
}
