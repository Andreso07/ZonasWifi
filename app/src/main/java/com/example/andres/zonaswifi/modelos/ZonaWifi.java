package com.example.andres.zonaswifi.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andres on 10/26/17.
 */

public class ZonaWifi {

    @SerializedName("ancho_de_banda")
    @Expose
    private String anchoDeBanda;
    @SerializedName("direcci_n")
    @Expose
    private String direcciN;
    @SerializedName("latitud")
    @Expose
    private Double latitud;
    @SerializedName("longitud")
    @Expose
    private Double longitud;
    @SerializedName("nombre_de_la_zona_wifi")
    @Expose
    private String nombreDeLaZonaWifi;
    @SerializedName("operador")
    @Expose
    private String operador;
    @SerializedName("reuso")
    @Expose
    private String reuso;

    public String getAnchoDeBanda() {
        return anchoDeBanda;
    }

    public void setAnchoDeBanda(String anchoDeBanda) {
        this.anchoDeBanda = anchoDeBanda;
    }

    public String getDirecciN() {
        return direcciN;
    }

    public void setDirecciN(String direcciN) {
        this.direcciN = direcciN;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getNombreDeLaZonaWifi() {
        return nombreDeLaZonaWifi;
    }

    public void setNombreDeLaZonaWifi(String nombreDeLaZonaWifi) {
        this.nombreDeLaZonaWifi = nombreDeLaZonaWifi;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getReuso() {
        return reuso;
    }

    public void setReuso(String reuso) {
        this.reuso = reuso;
    }
}
