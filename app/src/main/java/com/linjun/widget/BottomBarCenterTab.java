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
        this.icon =icon;
       /* TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackgroundDrawable(drawable);
        typedArray.recycle();*/
        setOrientation(LinearLayout.VERTICAL);
        mIcon = new ImageView(context);
//        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
        LayoutParams params = new LayoutParams(72, 72);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = ContextUtils.dip2px(context, 2.5f);
        mIcon.setVisibility(INVISIBLE);
        mIcon.setImageResource(icon);
        mIcon.setLayoutParams(params);

        // mIcon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        LayoutParams textViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewParams.gravity = Gravity.CENTER_HORIZONTAL;
//         textViewParams.addRule(ALIGN_PARENT_BOTTOM);
        textViewParams.topMargin = ContextUtils.dip2px(context, 0.5f);
        textViewParams.bottomMargin = ContextUtils.dip2px(context, 2.5f);
        mTextView = new TextView(context);
        mTextView.setText(title);
        mTextView.setTextSize(ContextUtils.dip2px(context, 3.2f));
        mTextView.setLayoutParams(textViewParams);
        addView(mIcon);
        addView(mTextView);
    }


}
