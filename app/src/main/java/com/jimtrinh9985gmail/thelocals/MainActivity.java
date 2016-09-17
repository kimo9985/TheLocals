package com.jimtrinh9985gmail.thelocals;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.awareness.snapshot.LocationResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.wearable.Wearable;

/**
 * Created by Kimo on 8/25/2016.
 */
public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    public final String LOG_TAG = MainActivity.class.getSimpleName();

    GoogleApiClient mGoogleApiClient;

    TextView locationText;

    LocationRequest getLocation;
    //LocationResult locationResult;
    //Location lastLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        locationText = (TextView) findViewById(R.id.my_location);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
        Log.d(LOG_TAG, "GoogleApiClient Connected!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
            Log.d(LOG_TAG, "GoogleApiClient Disconnected!");
        }
    }

    @Override
    public void onConnected(Bundle bundle) {

        if () {

            createLocationRequest();

            LocationServices.FusedLocationApi.requestLocationUpdates
                    (mGoogleApiClient, getLocation, this);

            if (lastLocation != null) {
                Log.d(LOG_TAG, "Lat: " + lastLocation.getLatitude());
                Log.d(LOG_TAG, "Long: " + lastLocation.getLongitude());
            } else {
                Log.d(LOG_TAG, "Location Null!");
            }

            if (mGoogleApiClient.isConnected()) {
                Log.d(LOG_TAG, "Lat: " + getLocation.toString());
                Log.d(LOG_TAG, "Long: " + getLocation);
            }

            return;
        }
        Log.d(LOG_TAG, "CheckSelf Failed, implement onRequest!!!");
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 0);
    }

    protected void createLocationRequest() {
        getLocation = new LocationRequest();
        getLocation.setInterval(100000);
        getLocation.setFastestInterval(5000);
        getLocation.setSmallestDisplacement(5);
        getLocation.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.d(LOG_TAG, "onLocationChanged!");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}