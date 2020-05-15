package com.example.loginkeyboard.customview.costomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginkeyboard.R;

public class LoginPageView extends FrameLayout {
    private static final int VERIFY_CODE_SIZE = 6;

    private int mColor;

    private int mVerifyCodeSize = VERIFY_CODE_SIZE;

    private CheckBox mCheckBox;

    private OnLoginPageViewListener mOnLoginPageViewListener = null;

    public LoginPageView(@NonNull Context context) {
        this(context, null);
    }

    public LoginPageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginPageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化属性
        initAttr(context, attrs);
        //初始化控件
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_loginpageview,this);
        mCheckBox = findViewById(R.id.cb_report);
        EditText et_verifyCode = findViewById(R.id.et_verify_code);
        if(mColor != -1 ){
            mCheckBox.setTextColor(mColor);
        }
        if(mVerifyCodeSize != VERIFY_CODE_SIZE){
            et_verifyCode.setFilters(new InputFilter[]{
                    new InputFilter.LengthFilter(mVerifyCodeSize)
            });
        }
    }

    private void initAttr(@NonNull Context context, @Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoginPageView);
        mColor = a.getColor(R.styleable.LoginPageView_mainColor, -1);
        mVerifyCodeSize = a.getInt(R.styleable.LoginPageView_verifyCodeSize, 4);
        a.recycle();
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int mColor) {
        this.mColor = mColor;
    }

    public int getVerifyCodeSize() {
        return mVerifyCodeSize;
    }

    public void setVerifyCodeSize(int mVerifyCodeSize) {
        this.mVerifyCodeSize = mVerifyCodeSize;
    }


    public interface  OnLoginPageViewListener{
        void onClickGetVerifyCode(int phoneNum);

        void onOpenAgreement();

        void OnClickConfirm(String phone,String verifyCode);
    }

    public void setOnLoginPageViewListener(OnLoginPageViewListener loginPageViewListener){
        this.mOnLoginPageViewListener = loginPageViewListener;
    }
}
