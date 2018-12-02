package com.example.main.Entity;

public class Priorytet {
    int id_priorytet;
    String nazwa;

    public Priorytet(int id_priorytet, String nazwa) {
        this.id_priorytet = id_priorytet;
        this.nazwa = nazwa;
    }

    public int getId_priorytet() {
        return id_priorytet;
    }

    public void setId_priorytet(int id_priorytet) {
        this.id_priorytet = id_priorytet;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
