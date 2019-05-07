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

    public int getId_komentarza() {
        return id_komentarza;
    }

    public void setId_komentarza(int id_komentarza) {
        this.id_komentarza = id_komentarza;
    }

    public int getId_prac() {
        return id_prac;
    }

    public void setId_prac(int id_prac) {
        this.id_prac = id_prac;
    }

    public int getId_zglosz() {
        return id_zglosz;
    }

    public void setId_zglosz(int id_zglosz) {
        this.id_zglosz = id_zglosz;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
