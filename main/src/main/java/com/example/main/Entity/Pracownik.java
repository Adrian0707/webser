package com.example.main.Entity;

public class Pracownik {

  private  int id_prac;
  private  String imie;
  private  String nazwisko;
  private  String email;
  private  String login;
  private  String haslo;
  protected   Boolean nadzorca;

    protected Pracownik(int id_prac, String imie, String nazwisko, String email, String login, String haslo, Boolean nadzorca) {
        this.id_prac = id_prac;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
        this.nadzorca = nadzorca;
    }

    public Pracownik() {
    }

    public int getId_prac() {
        return id_prac;
    }

    public void setId_prac(int id_prac) {
        this.id_prac = id_prac;
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

    public boolean getNadzorca() {
        return nadzorca;
    }
}

