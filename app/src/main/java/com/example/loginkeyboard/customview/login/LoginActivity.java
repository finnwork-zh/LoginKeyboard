package com.example.loginkeyboard.customview.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.loginkeyboard.R;
import com.example.loginkeyboard.customview.costomview.LoginKeyboard;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        LoginKeyboard loginKeyboard = findViewById(R.id.keyboard);
        loginKeyboard.setOnKeyPressListener(new LoginKeyboard.OnKeyPressListener() {
            @Override
            public void onNumPress(String number) {
                Log.d(TAG, "onNumPress: " + number);
            }

            @Override
            public void onDeleteNum() {
                Log.d(TAG, "onNumPress: delete");
            }
        });
    }
}
