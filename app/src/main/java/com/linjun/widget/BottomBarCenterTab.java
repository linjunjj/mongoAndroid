package com.linjun.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.linjun.R;
import com.linjun.utils.ContextUtils;

public class BottomBarCenterTab extends RelativeLayout {
    private ImageView mIcon;
    private ImageView cIcon;
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
             mContext=context;
             this.icon=icon;
             mIcon=new ImageView(context);
             cIcon=new ImageView(context);
         LayoutParams conParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
               conParams.addRule(RelativeLayout.CENTER_IN_PARENT);
              cIcon.setImageResource(R.drawable.tabbar_compose_button);
              cIcon.setLayoutParams(conParams);
             LayoutParams iconParams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
             iconParams.addRule(RelativeLayout.CENTER_IN_PARENT);
             mIcon.setImageResource(icon);
             mIcon.setLayoutParams(iconParams);
             addView(cIcon);
            addView(mIcon);
//        addView(relativeLayout, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }
    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {

        } else {
//            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_unselect));
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
