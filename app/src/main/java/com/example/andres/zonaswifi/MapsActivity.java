package com.example.andres.zonaswifi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.andres.zonaswifi.api.Datos;
import com.example.andres.zonaswifi.modelos.ZonaWifi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Retrofit retrofit;
    private String TAG="Datos api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();
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
        Datos service = retrofit.create(Datos.class);
        final Call<List<ZonaWifi>> institucionCall = service.obtenerListaZonaWifi();

        institucionCall.enqueue(new Callback<List<ZonaWifi>>() {
            @Override
            public void onResponse(Call<List<ZonaWifi>> call, Response<List<ZonaWifi>> response) {

                if (response.isSuccessful()) {
                    List zonaWifis = response.body();
                    for (int i = 0; i < zonaWifis.size(); i++) {
                        ZonaWifi z = (ZonaWifi) zonaWifis.get(i);
                        // Add a marker in Sydney and move the camera
                        LatLng sydney = new LatLng(z.getLatitud(), z.getLongitud());
                        mMap.addMarker(new MarkerOptions().position(sydney).title(z.getNombreDeLaZonaWifi()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                        mMap.getUiSettings().setZoomControlsEnabled(true);
                        mMap.setMinZoomPreference(10.0f);

                    }
                } else {

                    Log.e(TAG,"OnResponse "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<ZonaWifi>> call, Throwable t) {

            }
        });
    }
}
