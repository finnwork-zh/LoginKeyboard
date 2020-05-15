package com.example.loginkeyboard.customview.costomview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.loginkeyboard.R;

public class LoginKeyboard extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "LoginKeyboard";
    private OnKeyPressListener mKeyPressListener = null;

    public LoginKeyboard(Context context) {
        this(context, null);
    }

    public LoginKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //加载布局
        LayoutInflater.from(context).inflate(R.layout.custom_loginkeyboard, this);
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_num_0).setOnClickListener(this);
        findViewById(R.id.tv_num_1).setOnClickListener(this);
        findViewById(R.id.tv_num_2).setOnClickListener(this);
        findViewById(R.id.tv_num_3).setOnClickListener(this);
        findViewById(R.id.tv_num_4).setOnClickListener(this);
        findViewById(R.id.tv_num_5).setOnClickListener(this);
        findViewById(R.id.tv_num_6).setOnClickListener(this);
        findViewById(R.id.tv_num_7).setOnClickListener(this);
        findViewById(R.id.tv_num_8).setOnClickListener(this);
        findViewById(R.id.tv_num_9).setOnClickListener(this);
        findViewById(R.id.tv_num_point).setOnClickListener(this);
        findViewById(R.id.iv_num_del).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( mKeyPressListener == null){
            Log.d(TAG, "mKeyPressListener is null");
            return;
        }
        if (v.getId() == R.id.iv_num_del) {
            //删除
            mKeyPressListener.onDeleteNum();
        } else {
            //数字
            CharSequence text = ((TextView) v).getText();
            Log.d(TAG, "keyboard" + text);
            mKeyPressListener.onNumPress((String) text);
        }
    }


    /*
     * desc: 暴露接口
     * methodName: OnKeyPressListener
     * date: 2020/5/14
     */
    public interface OnKeyPressListener {
        void onNumPress(String number);

        void onDeleteNum();
    }

    public void setOnKeyPressListener(OnKeyPressListener keyPressListener) {
        this.mKeyPressListener = keyPressListener;
    }
}
