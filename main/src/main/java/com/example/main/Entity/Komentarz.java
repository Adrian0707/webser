package com.example.main.Entity;

import java.util.Date;

public class Komentarz {
    int id_komentarza;
    int id_prac;
    int id_zglosz;
    String comment;
    Date data;

    public Komentarz(int id_komentarza, int id_prac, int id_zglosz, String comment, Date data) {
        this.id_komentarza = id_komentarza;
        this.id_prac = id_prac;
        this.id_zglosz = id_zglosz;
        this.comment = comment;
        this.data = data;
    }
}
