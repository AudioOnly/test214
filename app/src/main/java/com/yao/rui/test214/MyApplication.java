package com.yao.rui.test214;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Rny on 2017/2/14.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    public static Context applicationContext;

    // 记录是否已经初始化
    private boolean isInit = false;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
        //初始化
    }
    //单例
    public static MyApplication getInstance() {
        return instance;
    }
}
