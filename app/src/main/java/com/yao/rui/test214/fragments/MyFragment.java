package com.yao.rui.test214.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yao.rui.test214.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rny on 2017/3/17.
 */

public class MyFragment extends Fragment {


    public static MyFragment inStance(String title_str){
        MyFragment fragment=new MyFragment();
        Bundle b=new Bundle();
        b.putString("title",title_str);
        fragment.setArguments(b);
        return fragment;
    }

    @BindView(R.id.fragment_tv)
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        tv.setText(getArguments().getString("title"));
    }
}
