package com.example.main.Entity;

import java.sql.Date;

public class Zgloszenie {
    int id_zglosz;
    int id_uzyt;
    int id_kategoria;
    int id_status;
    int id_priorytet;
    String opis;
    String obraz;
    Date data_przyj;
    Date data_max;
    Date data_real;
    String nazwa;



    public Zgloszenie(int id, int id_uzyt, int id_kategoria, int id_status, int id_priorytet,
                      String opis, String obraz, Date data_przyj, Date data_max, Date data_real, String nazwa) {
        this.id_zglosz = id;
        this.id_uzyt = id_uzyt;
        this.id_kategoria = id_kategoria;
        this.id_status = id_status;
        this.id_priorytet = id_priorytet;
        this.opis = opis;
        this.obraz = obraz;
        this.data_przyj = data_przyj;
        this.data_max = data_max;
        this.data_real = data_real;
        this.nazwa=nazwa;

    }

    public int getId_zglosz() {
        return id_zglosz;
    }

    public void setId_zglosz(int id) {
        this.id_zglosz = id;
    }

    public int getId_uzyt() {
        return id_uzyt;
    }

    public void setId_uzyt(int id_uzyt) {
        this.id_uzyt = id_uzyt;
    }

    public int getId_kategoria() {
        return id_kategoria;
    }

    public void setId_kategoria(int id_kategoria) {
        this.id_kategoria = id_kategoria;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public int getId_priorytet() {
        return id_priorytet;
    }

    public void setId_priorytet(int id_priorytet) {
        this.id_priorytet = id_priorytet;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getObraz() {
        return obraz;
    }

    public void setObraz(String obraz) {
        this.obraz = obraz;
    }

    public Date getData_przyj() {
        return data_przyj;
    }

    public void setData_przyj(Date data_przyj) {
        this.data_przyj = data_przyj;
    }

    public Date getData_max() {
        return data_max;
    }

    public void setData_max(Date data_max) {
        this.data_max = data_max;
    }

    public Date getData_real() {
        return data_real;
    }

    public void setData_real(Date data_real) {
        this.data_real = data_real;
    }
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
