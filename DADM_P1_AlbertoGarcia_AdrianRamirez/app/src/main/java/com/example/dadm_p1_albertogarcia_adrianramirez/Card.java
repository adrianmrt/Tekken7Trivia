package com.example.dadm_p1_albertogarcia_adrianramirez;

public class Card {
    private int imagen;
    private String nombre;
    private int pais;

    public Card (int img, String nmb, int p){
        this.imagen=img;
        this.nombre=nmb;
        this.pais=p;
    }

    public int getImagen(){
        return imagen;
    }

    public int getPais(){
        return pais;
    }

    public String getNombre(){
        return nombre;
    }
}
