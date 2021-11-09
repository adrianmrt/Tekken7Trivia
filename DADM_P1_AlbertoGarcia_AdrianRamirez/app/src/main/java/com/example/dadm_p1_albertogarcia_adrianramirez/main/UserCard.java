package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import com.example.dadm_p1_albertogarcia_adrianramirez.database.DatabaseViewModel;

import java.util.Date;

public class UserCard {
    private int imagen;
    private String nombre;
    private int puntuacion;
    private int partidas;
    private String ultimaConexion;

    public UserCard(String nmb, String date) {
        this.imagen = 0;
        this.nombre = nmb;
        this.puntuacion = 0;
        this.partidas = 0;
        this.ultimaConexion = date;
    }

    public UserCard(int img, String nmb, String date) {
        this.imagen = img;
        this.nombre = nmb;
        this.puntuacion = 0;
        this.partidas = 0;
        this.ultimaConexion = date;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public String getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(String ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
}
