package com.MostafaCovied.Mostafacovied.Tracing;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.MostafaCovied.Mostafacovied.R;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class live_tracting extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    String uid;
    String latitude;
    String longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tracting);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        uid = intent.getStringExtra("id");
        Toast.makeText(this, intent.getStringExtra("id"), Toast.LENGTH_SHORT).show();
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
        Intent intent = getIntent();

        String user_ID = intent.getStringExtra("user_id");
        final String user_name = intent.getStringExtra("user_name");
        firebaseFirestore.collection("Users").document(user_ID).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

              //  if (documentSnapshot != null) {
                  //  for (final DocumentSnapshot snapshot : documentSnapshot) {

                      //  Healthy_model healthy_model = snapshot.toObject(Healthy_model.class);
                        double Longitude= Double.parseDouble(String.valueOf(documentSnapshot.getDouble("Longitude")));
                        double Latitude= Double.parseDouble(String.valueOf(documentSnapshot.getDouble("Latitude")));
                      //  final String name = healthy_model.getName();
//                        double Longitude = healthy_model.getLongitude();
//                        double Latitude = healthy_model.getLatitude();
                        LatLng sydney = new LatLng(Latitude, Longitude);
                        mMap.addMarker(new MarkerOptions().position(sydney)).setTitle(user_name);
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(sydney).zoom(16f).build()));
                  //  }
               // }
            }
        });


//        double lat = intent.getDoubleExtra("latitude", +1);
//        double longitude = intent.getDoubleExtra("longitude", +1);
////1        double accuracy = intent.getDoubleExtra("accuracy", +1);
////        double elapsedRealtimeNanos = intent.getDoubleExtra("elapsedRealtimeNanos", +1);
////        double speed = intent.getDoubleExtra("speed", +1);
////        double time = intent.getDoubleExtra("time", +1);
//        String name=intent.getStringExtra("user_name");
//
//        Toast.makeText(this, lat+""+longitude+""+""+name, Toast.LENGTH_SHORT).show();
//        LatLng sydney = new LatLng(lat, longitude);
//
//        mMap.addMarker(new MarkerOptions().position(sydney)).setTitle(name);
//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().target(sydney).zoom(16f).build()));

//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(new LatLng(lat, longitude));
//        markerOptions.title(name+"");
//        mMap.addMarker(markerOptions);
//        mMap.animateCamera(CameraUpdateFactory.zoomBy(17));
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.getUiSettings().setZoomGesturesEnabled(true);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //   mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,16f));

    }

}
