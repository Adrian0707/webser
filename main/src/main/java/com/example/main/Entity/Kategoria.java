package com.example.main.Entity;


public class Kategoria {

    int id_kategoria;

    String nazwa;

    public Kategoria(int id_kategoria, String nazwa) {
        this.id_kategoria = id_kategoria;
        this.nazwa = nazwa;
    }

    public int getId_kategoria() {
        return id_kategoria;
    }

    public void setId_kategoria(int id_kategoria) {
        this.id_kategoria = id_kategoria;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
