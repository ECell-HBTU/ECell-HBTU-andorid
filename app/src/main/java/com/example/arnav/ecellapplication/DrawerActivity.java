package com.example.arnav.ecellapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.GravityCompat;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.menu.activity_main_drawer);
        setNavigationViewListner();
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = findViewById(R.id.navDraw);
        navigationView.setNavigationItemSelectedListener(this);
    }

            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.team) {
                    Intent mi = new Intent(DrawerActivity.this, TeammActivity.class);
                    startActivity(mi);

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
            }

