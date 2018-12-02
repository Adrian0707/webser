package com.example.main.Entity;

import java.sql.Date;

public class Zloszenie {
    int id;
    int id_uzyt;
    int id_kategoria;
    int id_status;
    int id_priorytet;
    String opis;
    String obraz;
    Date data_przyj;
    Date data_max;
    Date data_real;

    public Zloszenie(int id, int id_uzyt, int id_kategoria, int id_status, int id_priorytet, String opis, String obraz, Date data_przyj, Date data_max, Date data_real) {
        this.id = id;
        this.id_uzyt = id_uzyt;
        this.id_kategoria = id_kategoria;
        this.id_status = id_status;
        this.id_priorytet = id_priorytet;
        this.opis = opis;
        this.obraz = obraz;
        this.data_przyj = data_przyj;
        this.data_max = data_max;
        this.data_real = data_real;
    }
}
