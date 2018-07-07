package com.linjun.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linjun.R;
import com.linjun.utils.ContextUtils;

public class BottomBarCenterTab extends LinearLayout {
    private ImageView mIcon;
    private Context mContext;
    private  int icon;
    private TextView mTextView;

    private int mTabPosition = -1;
    private  RelativeLayout relativeLayout;

    public BottomBarCenterTab(Context context, @DrawableRes int icon,String title) {
        this(context,null,icon,title);
    }
    public BottomBarCenterTab(Context context, AttributeSet attrs,int icon,String title) {
      this(context,attrs,0,icon,title);
    }

    public BottomBarCenterTab(Context context, AttributeSet attrs, int defStyleAttr,int icon,String title) {
        super(context, attrs, defStyleAttr);
        init(context,icon,title);
    }

    private void init(Context context, int icon,String title) {
             mContext=context;
             this.icon=icon;
             mIcon=new ImageView(context);
             LayoutParams iconParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
             iconParams.gravity = Gravity.CENTER_HORIZONTAL;
            iconParams.topMargin = ContextUtils.dip2px(context, 4.5f);
             mIcon.setImageResource(icon);
             mIcon.setLayoutParams(iconParams);
             mIcon.setVisibility(View.INVISIBLE);
            addView(mIcon);
        mTextView = new TextView(context);
        LayoutParams textViewParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        textViewParams.topMargin = ContextUtils.dip2px(context, 2.5f);
        textViewParams.bottomMargin = ContextUtils.dip2px(context, 2.5f);
        mTextView.setText(title);
        mTextView.setGravity(Gravity.END);
        mTextView.setTextSize(ContextUtils.dip2px(context, 3.2f));
        mTextView.setLayoutParams(textViewParams);
        mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.tab_unselect));
        addView(mTextView);
    }


}
