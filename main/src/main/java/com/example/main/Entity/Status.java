package com.example.main.Entity;

public class Status {
    int id_status;
    String nazwa;

    public Status(int id_status, String nazwa) {
        this.id_status = id_status;
        this.nazwa = nazwa;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
