package com.example.dadm_p1_albertogarcia_adrianramirez.main;

public class Card {
    private int imagen;
    private String nombre;
    private int pais;
    private String _description;

    public Card (int img, String nmb, int pais, String description){
        this.imagen=img;
        this.nombre=nmb;
        this.pais=pais;
        _description=description;
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

    public String get_description() {
        return _description;
    }
}
