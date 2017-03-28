package com.yao.rui.test214.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yao.rui.test214.R;

/**
 * Created by Rny on 2017/3/20.
 */

public class MyText extends View {

    private Paint mPaint;
    private String text_str;
    public MyText(Context context) {
        super(context);
    }

    public MyText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        //获取TypeArray
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.testview);
        //获取attrs.xml里面的属性值，格式为：名称_属性名，后面是默认值
        int textColor = array.getColor(R.styleable.testview_textColor, Color.GREEN);
        float textSize = array.getDimension(R.styleable.testview_textSize, 35);
        text_str = array.getString(R.styleable.testview_textStr);
        //设置画笔
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
        //返回一个绑定资源结束的信号给资源
        array.recycle();

        // 添加 修改判断 命令git diff origin/master master ，输出的结果
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!text_str.isEmpty())
            canvas.drawText(text_str, 10, 58, mPaint);
    }

    public String getText_str() {
        return text_str;
    }

    public void setText_str(String text_str) {
        this.text_str = text_str;
    }
}
