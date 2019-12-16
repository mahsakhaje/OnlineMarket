package com.example.onlinemarket.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.onlinemarket.R;

public class SplashActivity extends AppCompatActivity {
    public static final int SPLASH_TIME = 3000;

    public static Intent newIntent(Context context){
    return new Intent(context,SplashActivity.class);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(getActionBar()!=null)
        getActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=HomePageActivity.newIntent(SplashActivity.this);
                startActivity(intent);
            }
        },SPLASH_TIME);


    }
}
