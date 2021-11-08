package com.example.dadm_p1_albertogarcia_adrianramirez.main;

import java.util.Date;

public class UserCard {
    private int imagen;
    private String nombre;
    private int puntuacion;
    private int partidas;
    private Date ultimaConexion;

    public UserCard(String nmb) {
        this.nombre = nmb;
    }

    public UserCard(int img, String nmb) {
        this.imagen = img;
        this.nombre = nmb;
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

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
}
