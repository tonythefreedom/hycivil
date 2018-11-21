package org.artoolkitx.arx.arsquaretracking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private ArrayList<Point3d> gd;
    private GraphView graph;
    private DataPoint[] dp;

    private DrawerLayout drawerLayout;
    private FrameLayout drawer_btn;
    private LinearLayout nav_item_01;
    private LinearLayout nav_item_02;
    private LinearLayout nav_item_03;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
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
        graph = (GraphView) findViewById(R.id.graph);
        Intent intent = getIntent();
        gd = (ArrayList<Point3d>)intent.getSerializableExtra("graphdata");

        context = this;

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

    public void displace_touch(View view)
    {

        dp = new DataPoint[gd.size() - 1];
        for (int i=0; i<gd.size()-1; i++)
        {
            double y = gd.get(i+1).distance(gd.get(i));
            double x = i+1;
            dp[i] = new DataPoint(x,y);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);
        graph.addSeries(series);
    }

}
