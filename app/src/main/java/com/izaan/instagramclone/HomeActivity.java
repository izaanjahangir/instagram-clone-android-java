package com.izaan.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.homeBottomNav);
        bottomNav.setOnNavigationItemSelectedListener(handleNavigationListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.innerConstraintLayout, new ExploreFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener handleNavigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmentItem = null;

            int itemId = item.getItemId();
            Log.i("izaan", "testing...");
            if(itemId == R.id.exploreNavItem) {
                fragmentItem = new ExploreFragment();
            }

            if(itemId == R.id.profileNavItem) {
                fragmentItem = new ProfileFragment();
            }

            if(itemId == R.id.uploadNavItem) {
                fragmentItem = new UploadFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.innerConstraintLayout, fragmentItem).commit();

            return false;
        }
    };

    public void handleUploadTabClick(View view){
//        Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();
    }
}