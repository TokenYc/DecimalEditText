package com.example.cc.decimaltest;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by .cc on 2016/3/15.
 */
public class DecimalEditText extends EditText{
    private static final int DEFAULT_NUM=2;//默认保留2位小数
    int decimalNum=DEFAULT_NUM;

    public DecimalEditText(Context context) {
        super(context);
        init();
    }


    public DecimalEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.DecimalEditText);
        decimalNum=typedArray.getInteger(0, DEFAULT_NUM);
        init();
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str=s.toString();
                int n=str.indexOf(".");
                if (n!=-1){
                    if ((str.length()-1-n)>decimalNum){
                        if (start==str.length()-1) {
                            setText(s.subSequence(0, n + decimalNum+1));
                            setSelection(str.length()-1);
                        }else{
                            setText(s.subSequence(0, start).toString()+s.subSequence(start + 1, str.length()));
                            setSelection(str.length()-1);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
