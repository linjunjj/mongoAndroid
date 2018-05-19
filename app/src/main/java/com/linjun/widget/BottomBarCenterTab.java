package com.linjun.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.linjun.R;

public class BottomBarCenterTab extends RelativeLayout {
    private ImageView mIcon;
    private Context mContext;
    private  int icon;
    private int mTabPosition = -1;
    private  RelativeLayout relativeLayout;

    public BottomBarCenterTab(Context context, @DrawableRes int icon) {
        this(context,null,icon);
    }

    public BottomBarCenterTab(Context context, AttributeSet attrs,int icon) {
      this(context,attrs,0,icon);
    }

    public BottomBarCenterTab(Context context, AttributeSet attrs, int defStyleAttr,int icon) {
        super(context, attrs, defStyleAttr);
        init(context,icon);
    }

    private void init(Context context, int icon) {
            relativeLayout=new RelativeLayout(context);
            relativeLayout.setBackground(getResources().getDrawable(R.drawable.tabbar_compose_button));
         LayoutParams  params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
           params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        relativeLayout.setLayoutParams(params);
            addView(relativeLayout, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
             mContext=context;
             this.icon=icon;
             mIcon=new ImageView(context);
             LayoutParams iconParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
             iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);
             mIcon.setImageResource(icon);
             mIcon.setLayoutParams(iconParams);
             relativeLayout.addView(mIcon);

    }
    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {

        } else {
            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_unselect));
        }
    }


    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }

}
