package org.artoolkitx.arx.arsquaretracking;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout drawerLayout;
    private FrameLayout drawer_btn;
    private LinearLayout nav_item_01;
    private LinearLayout nav_item_02;
    private LinearLayout nav_item_03;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.532600, 127.024612);

        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.ic_pin);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 200, 200, false);

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).position(sydney).title("Marker in Seoul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
