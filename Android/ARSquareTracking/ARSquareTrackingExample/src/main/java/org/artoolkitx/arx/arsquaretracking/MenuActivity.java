package org.artoolkitx.arx.arsquaretracking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity implements  View.OnClickListener {


    private DrawerLayout drawerLayout;
    private FrameLayout drawer_btn;
    private LinearLayout nav_item_01;
    private LinearLayout nav_item_02;
    private LinearLayout nav_item_03;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.cal_btn).setOnClickListener(this);
        findViewById(R.id.map_btn).setOnClickListener(this);
        findViewById(R.id.sensor_btn).setOnClickListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer_btn = (FrameLayout) findViewById(R.id.drawer_btn);
        nav_item_01 = (LinearLayout) findViewById(R.id.nav_item_01);
        nav_item_02 = (LinearLayout) findViewById(R.id.nav_item_02);
        nav_item_03 = (LinearLayout) findViewById(R.id.nav_item_03);

        drawer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        nav_item_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                Intent myinfoIntent = new Intent(context, MapsActivity.class);
                myinfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myinfoIntent);

            }
        });

        nav_item_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                Intent storeIntent = new Intent(context, GraphActivity.class);
                storeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(storeIntent);
            }
        });

        nav_item_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
                Intent historyIntent = new Intent(context, MenuActivity.class);
                historyIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(historyIntent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.map_btn) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else if (i == R.id.cal_btn) {
            Intent intent = new Intent(this, ARSquareTrackingActivity.class);
            startActivity(intent);
        } else if (i == R.id.sensor_btn) {
            //Intent intent = new Intent(this, GetResultActivity.class);
            //startActivity(intent);
        }
    }
}
