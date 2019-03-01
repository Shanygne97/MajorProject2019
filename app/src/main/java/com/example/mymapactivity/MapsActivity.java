package com.example.mymapactivity;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        LatLng utech = new LatLng(18.0170384,-76.7439025);
        LatLng papine = new LatLng(18.0173879,-76.7447684);
        LatLng hopegarden = new LatLng(18.0164568,-76.7502427);
        mMap.addMarker(new MarkerOptions().position(utech).title("Marker of utech"));
        mMap.animateCamera(CameraUpdateFactory
                .newLatLngZoom(
                        utech,
                        14f)
        );
        mMap.addPolyline(
                new PolylineOptions()
                .add(utech)
                .add(papine)
                .add(hopegarden)
                .width(2f)
                .color(Color.RED)
        );

        mMap .addCircle(
                new CircleOptions()
                .center(utech)
                .radius(500.0)
                .strokeWidth(3f)
                .strokeColor(Color.RED)
                .fillColor(Color.argb(70, 150, 50, 50))
        );

    }

}
