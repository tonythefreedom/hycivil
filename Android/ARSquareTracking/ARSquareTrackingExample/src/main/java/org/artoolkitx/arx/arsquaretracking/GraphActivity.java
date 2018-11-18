package org.artoolkitx.arx.arsquaretracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private ArrayList<Point3d> gd;
    private GraphView graph;
    private DataPoint[] dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
