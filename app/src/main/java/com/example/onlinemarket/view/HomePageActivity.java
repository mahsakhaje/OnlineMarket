package com.example.onlinemarket.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.onlinemarket.R;

public class HomePageActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return HomePageFragment.newInstance();
    }
    public static Intent newIntent(Context context) {
        return new Intent(context, HomePageActivity.class);
    }
}
