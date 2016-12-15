package com.example.ivan.lab10_widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ivan on 11/27/16.
 */

public class LocationMain extends AppCompatActivity {
    Button btnShowLocation;
    Button gMaps;

    // GPSTracker class
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_tracker);
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        gMaps = (Button)findViewById(R.id.mapBtn);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                //gps = new GPSTracker(MainActivity.this);
                gps = new GPSTracker(LocationMain.this);

                // check if GPS enabled
                if (gps.canGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    if (latitude != 0.0 && longitude != 0.0) {

                        // \n is for new line
                        TextView loc = (TextView) findViewById(R.id.textLocation);
                        loc.setText("Your Location is - \nLat: " + latitude
                                + "\nLong: " + longitude);

                    } else {
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        gps.showSettingsAlert();
                    }
                }
            }
        });

        gMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(LocationMain.this);
                if (gps.canGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    if (latitude != 0.0 && longitude != 0.0 ) {

                        startGoogleMaps(latitude,longitude);

                    } else {
                        // can't get location
                        // GPS or Network is not enabled
                        // Ask user to enable GPS/network in settings
                        gps.showSettingsAlert();
                    }
                }
            }
        });


    }


    private void startGoogleMaps(double lat, double lng){
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("lat",lat);
        intent.putExtra("lng",lng);
        startActivity(intent);
    }
}
