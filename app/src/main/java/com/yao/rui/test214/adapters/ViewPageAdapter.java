package com.yao.rui.test214.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Rny on 2017/3/15.
 */

public class ViewPageAdapter extends PagerAdapter {
    private List<Object> lists;

    private boolean isHolder;

    public ViewPageAdapter(List<Object> lists) {
        this(lists,false);

    }

    public ViewPageAdapter(List<Object> lists, boolean isHolder) {
        this.lists = lists;
        this.isHolder = isHolder;
    }

    /**
     * 获取当前窗体界面数
     *
     * @return
     */
    @Override
    public int getCount() {
        return lists.size();
    }

    /**
     * return 一个对象，这个对象表明了PagerAdapter适配器选择的那个对象
     * 放在当前的Viewpager中
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=getItemView(position);
        container.addView(view);
        return view;
    }

    /**
     * 从 ViewGroup中移除当前View
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(getItemView(position));
    }

    /**
     * 用于判断是否由对象生成界面
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 获取View
     * @param position
     * @return
     */
    private View getItemView(int position) {
        Object object = lists.get(position);
        return isHolder ? ((BaseHolder) object).itemView : (View) object;
    }

    /**
     * 获取 holder
     * @param position
     * @param <T>
     * @return
     */
    private <T extends BaseHolder> T getHoler(int position){

        return (T) lists.get(position);
    }


    public static class BaseHolder {
        public View itemView;
        public BaseHolder(View root){
            this.itemView=root;
            ButterKnife.bind(this,root);
        }

        public <V> V findviewbyid(int id){
            return (V)itemView.findViewById(id);
        }
    }
}
