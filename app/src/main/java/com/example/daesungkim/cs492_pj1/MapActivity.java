package com.example.daesungkim.cs492_pj1;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

    static final LatLng SEOUL = new LatLng( 37.56, 126.97);
    private GoogleMap map;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
                    @Override
                    public void gotLocation(Location location) {
                        drawMarker(location);
                    }
                };

                MyLocation myLocation = new MyLocation();
                myLocation.getLocation(getApplicationContext(), locationResult);
            }
        });

        map = ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();
        Marker seoul = map.addMarker(new MarkerOptions().position(SEOUL)
                .title("Seoul"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));

        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }

    private void drawMarker(Location location) {

        //기존 마커 지우기
        map.clear();
        LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());

        //currentPosition 위치로 카메라 중심을 옮기고 화면 줌을 조정한다. 줌범위는 2~21, 숫자클수록 확대
        map.moveCamera(CameraUpdateFactory.newLatLngZoom( currentPosition, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        //마커 추가
        map.addMarker(new MarkerOptions()
                .position(currentPosition)
                .snippet("Lat:" + location.getLatitude() + "Lng:" + location.getLongitude())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title("Current Location"));
    }
}
