package com.example.main.Entity;

public class Uzytkownik {
    int id_uzyt;
    String imie;
    String nazwisko;
    String email;
    String login;
    String haslo;

    public Uzytkownik(int id, String imie, String nazwisko, String email, String login, String hasło) {
        this.id_uzyt = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
    }

    public int getId_uzyt() {
        return id_uzyt;
    }

    public void setId_uzyt(int id_uzyt) {
        this.id_uzyt = id_uzyt;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }
}
