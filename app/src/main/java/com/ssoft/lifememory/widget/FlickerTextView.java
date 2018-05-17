package com.ssoft.lifememory.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ssoft.lifememory.R;

/**
 * 实现textview闪烁，提供颜色 与间隔属性设置
 */
public class FlickerTextView extends TextView {
    //线性渐变
    private LinearGradient mLinearGradient;
    //渐变矩阵
    private Matrix mGradientMatrix;
    // 画笔
    private Paint mPaint;
    //移动距离
    private int mTraslate = 0;
    // 是否启动
    private boolean mAnimating = true;
    private int mDuration = 300;
    private int[] colors = new int[]{0x666622ff, 0xff0000ff, 0x666622ff};

    public FlickerTextView(Context context) {
        super(context);
        init(null);
    }

    public FlickerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context.getTheme().obtainStyledAttributes(attrs, R.styleable.FlickerTextView, 0, 0));
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,0,getMeasuredWidth(),0,
                        colors,
                        new float[]{0, 0.5f, 1},
                        Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mAnimating && mGradientMatrix != null){
            mTraslate += getMeasuredWidth()/10;
            if(mTraslate > 2*getMeasuredWidth()){
                mTraslate = -getMeasuredWidth();
            }
            mGradientMatrix.setTranslate(mTraslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(mDuration);

        }
    }

    /**
     * 初始化属性值
     * @param attrs 属性值
     */
    protected void init(TypedArray attrs){
        mDuration =attrs.getInteger(R.styleable.FlickerTextView_ftv_duration,mDuration);
        colors[0] = attrs.getInteger(R.styleable.FlickerTextView_color1,colors[0]);
        colors[1] = attrs.getInteger(R.styleable.FlickerTextView_color1,colors[1]);
        colors[2] = attrs.getInteger(R.styleable.FlickerTextView_color1,colors[2]);
    }

}

