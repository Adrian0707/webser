package com.example.main.Entity;

public class Nadzorca extends Pracownik {
    public Nadzorca(int id, String imie, String nazwisko, String email, String login, String haslo) {
        super(id, imie, nazwisko, email, login, haslo);
        this.nadzorca = true;
    }
}
