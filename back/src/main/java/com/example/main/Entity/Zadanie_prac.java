package com.example.main.Entity;

public class Zadanie_prac {
    int id;
    int id_zglosz;
    int id_prac;
    Double czas;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_zglosz(int id_zglosz) {
        this.id_zglosz = id_zglosz;
    }

    public void setId_prac(int id_prac) {
        this.id_prac = id_prac;
    }

    public Double getCzas() {
        return czas;
    }

    public void setCzas(Double czas) {
        this.czas = czas;
    }

    public Zadanie_prac(int id, int id_zglosz, int id_prac,Double czas) {
        this.id = id;
        this.id_zglosz = id_zglosz;
        this.id_prac = id_prac;
        this.czas=czas;
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
