package com.example.task_1.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.task_1.Fragment.Screen2;
import com.example.task_1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Screen1 extends AppCompatActivity {
    BottomNavigationView navigationView;
    View notificationIndicatior;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        navigationView = findViewById(R.id.bottom);
        navigationView.setOnNavigationItemSelectedListener(navListener);

        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.background));


    }
    public boolean loadfragments(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
        }
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:

                    break;
                case R.id.calender:
                    fragment = new Screen2();

                    break;
                case R.id.notification:

                    break;
                case R.id.search:

                    break;
            }
            return loadfragments(fragment);
        }
    };
    public void onBackPressed() {
        if (navigationView.getSelectedItemId() == R.id.home) {
            super.onBackPressed();
            finish();
        } else {
            navigationView.setSelectedItemId(R.id.home);
        }
    }

}