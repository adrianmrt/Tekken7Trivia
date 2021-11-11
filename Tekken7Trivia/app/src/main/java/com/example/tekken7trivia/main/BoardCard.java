package com.example.tekken7trivia.main;

public class BoardCard {
    private String nombre;
    private int score;
    private float time;

    public BoardCard(String nmb, int score, float time) {
        this.nombre = nmb;
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public float getTime() {
        return time;
    }

    public String getNombre() {
        return nombre;
    }


}
