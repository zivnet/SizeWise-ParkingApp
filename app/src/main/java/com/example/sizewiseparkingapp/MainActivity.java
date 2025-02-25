package com.example.sizewiseparkingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.example.sizewiseparkingapp.ui.screens.RequestSensorActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.sizewiseparkingapp.ui.fragments.*;
import com.example.sizewiseparkingapp.ui.base.BaseDrawerActivity;

public class MainActivity extends BaseDrawerActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBottomNavigation();
        setupNavigationDrawer();
        handleInitialNavigation(savedInstanceState);
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_map) {
                return loadFragment(new MapFragment());
            }
            return true; // Just return true to keep the item selected without navigation
        });
    }

    private void setupNavigationDrawer() {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_request_sensor) {
                startActivity(new Intent(this, RequestSensorActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
            Fragment fragment = getFragmentForNavigationItem(item.getItemId());
            return loadFragment(fragment);
        });
    }

    private void handleInitialNavigation(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadFragment(new MapFragment());
        }
    }

    private Fragment getFragmentForNavigationItem(int itemId) {
        if (itemId == R.id.nav_map || itemId == R.id.bottom_map) {
            return new MapFragment();
        }
        return null;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

