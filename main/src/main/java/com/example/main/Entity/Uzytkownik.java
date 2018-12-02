package com.example.main.Entity;

public class Uzytkownik {
    int id;
    String imie;
    String nazwisko;
    String email;
    String login;
    String hasło;

    public Uzytkownik(int id, String imie, String nazwisko, String email, String login, String hasło) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.login = login;
        this.hasło = hasło;
    }

    public int getId() {
        return id;
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

    public String getHasło() {
        return hasło;
    }
}
