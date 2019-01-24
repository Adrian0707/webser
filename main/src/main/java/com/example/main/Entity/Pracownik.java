package com.example.main.Entity;

import javax.persistence.*;


public class Pracownik {

  private  int id;
  private  String imie;
  private  String nazwisko;
  private  String email;
  private  String login;
  private  String haslo;
 protected   boolean nadzorca;

    protected Pracownik(int id, String imie, String nazwisko, String email, String login, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
        this.nadzorca = false;
    }

    public Pracownik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setNadzorca(boolean nadzorca) {
        this.nadzorca = nadzorca;
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

    public boolean isNadzorca() {
        return nadzorca;
    }
}

