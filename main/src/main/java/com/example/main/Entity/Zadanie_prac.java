package com.example.main.Entity;

public class Zadanie_prac {
    int id;
    int id_zglosz;
    int id_prac;

    public Zadanie_prac(int id, int id_zglosz, int id_prac) {
        this.id = id;
        this.id_zglosz = id_zglosz;
        this.id_prac = id_prac;
    }

    public int getId() {
        return id;
    }

    public int getId_zglosz() {
        return id_zglosz;
    }

    public int getId_prac() {
        return id_prac;
    }
}
