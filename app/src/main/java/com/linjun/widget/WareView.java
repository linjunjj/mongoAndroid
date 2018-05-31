package com.linjun.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：林俊 on 2017/7/28
 * 作用：
 */
public class WareView extends View {
    private Path mAbovePath,mBelowMavePath;
    private Paint mAboveWarePaint,mBeloWavePaint;
    private DrawFilter mDrawFilter;
    private  float a;
    private  OnWaveAnimationListener mWaveAnimationListener;
    public WareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mAbovePath=new Path();
        mBelowMavePath=new Path();

        mAboveWarePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mAboveWarePaint.setAntiAlias(true);
        mAboveWarePaint.setStyle(Paint.Style.FILL);
        mAboveWarePaint.setColor(Color.WHITE);

        mBeloWavePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mBeloWavePaint.setAntiAlias(true);
        mBeloWavePaint.setStyle(Paint.Style.FILL);
        mBeloWavePaint.setColor(Color.WHITE);
        mBeloWavePaint.setAlpha(80);

        mDrawFilter=new PaintFlagsDrawFilter(0,Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(mDrawFilter);

        mAbovePath.reset();
        mBelowMavePath.reset();
        a-=0.095f;
        float y,y2;
        double w=2*Math.PI/getWidth();
        mAbovePath.moveTo(getLeft(),getBottom());
        mBelowMavePath.moveTo(getLeft(),getBottom());
        for (float x=0;x<=getWidth();x+=40){
            y= (float) (8*Math.cos(w*x+a)+8);
            y2= (float) (8*Math.sin(w*x+a));
            mAbovePath.lineTo(x,y);
            mBelowMavePath.lineTo(x,y2);
            mWaveAnimationListener.OnWaveAnimation(y);
        }
        mAbovePath.lineTo(getRight(),getBottom());
        mBelowMavePath.lineTo(getRight(),getBottom());
        canvas.drawPath(mAbovePath,mAboveWarePaint);
        canvas.drawPath(mBelowMavePath,mBeloWavePaint);
        postInvalidateDelayed(20);
    }
    public  void setOnWareAnimationListener(OnWaveAnimationListener listener){
        this.mWaveAnimationListener=listener;
    }
    public interface  OnWaveAnimationListener{
        void OnWaveAnimation(float y);
    }
}
