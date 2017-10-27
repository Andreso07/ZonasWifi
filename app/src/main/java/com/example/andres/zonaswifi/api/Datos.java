package com.example.andres.zonaswifi.api;

import com.example.andres.zonaswifi.modelos.ZonaWifi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andres on 10/26/17.
 */

public interface Datos {

    @GET("n4ms-tprw.json")
    Call<List<ZonaWifi>> obtenerListaZonaWifi();
}
