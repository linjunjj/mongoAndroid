package com.linjun.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.linjun.R;

/**
 * 作者：林俊 on 2017/7/28
 * 作用：
 */
public class EditTextWithDeleteButton extends EditText implements View.OnFocusChangeListener, TextWatcher{
    private final static String TAG = "EditTextWithDel";
    private Drawable imgAble;
    private Context mContext;
   private boolean hasFocus;


    public EditTextWithDeleteButton(Context context) {
        super(context);
        mContext = context;
        init();
    }
    public EditTextWithDeleteButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }
    public EditTextWithDeleteButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    private void init() {
         imgAble=getCompoundDrawables()[2];
         if (imgAble==null){
             imgAble = mContext.getResources().getDrawable(R.drawable.ic_clear);
         }
         imgAble.setBounds(0,0,imgAble.getIntrinsicWidth(),imgAble.getIntrinsicHeight());
        setClearIconVisible(false);
        // 设置焦点改变的监听
        setOnFocusChangeListener(this);
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(this);

//        imgAble = mContext.getResources().getDrawable(R.drawable.ic_clear);
//        addTextChangedListener(new TextWatcher() {
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//            @Override
//            public void afterTextChanged(Editable s) {
//                setDrawable();
//            }
//        });
        //setDrawable();
    }



    // 处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {

                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight()) && (event.getX() < ((getWidth() - getPaddingRight())));
                if (touchable) {
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (hasFocus){
            setClearIconVisible(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        this.hasFocus = b;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }

    }
    protected void setClearIconVisible(boolean visible) {
        Drawable right = visible ? imgAble : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }


}
