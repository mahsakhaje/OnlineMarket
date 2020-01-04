package com.example.onlinemarket.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.onlinemarket.R;
import com.example.onlinemarket.databinding.ActivityHomePageBinding;
import com.example.onlinemarket.databinding.SearchLayoutBinding;
import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityHomePageBinding mView;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    SearchLayoutBinding mMainView;

    public static Intent newIntent(Context context) {
        return new Intent(context, HomePageActivity.class);
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        mMainView = DataBindingUtil.setContentView(this, R.layout.search_layout);
        mDrawerLayout = mView.drawer;
        mNavigationView = mView.navigationHome;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mMainView.toolbarActivityHome, R.string.open, R.string.close);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setSupportActionBar(mMainView.toolbarActivityHome);
        //    mMainView.toolbarActivityHome.setNavigationOnClickListener(new View.OnClickListener() {

      //  mDrawerLayout.openDrawer(Gravity.START);

        mMainView.toolbarActivityHome.setNavigationOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerLayout.setDrawerListener(toggle);
        mNavigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.container_Fragment_home);
        if (fragment == null)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.container_Fragment_home, HomePageFragment.newInstance())
                    .commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        mDrawerLayout.closeDrawer(Gravity.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }
}
