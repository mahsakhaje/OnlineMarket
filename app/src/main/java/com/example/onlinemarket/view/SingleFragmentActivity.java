package com.example.onlinemarket.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.onlinemarket.R;

public  abstract class SingleFragmentActivity extends AppCompatActivity {
public abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentscontainor);
        if (fragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentscontainor, createFragment())
                    .commit();

    }
}
