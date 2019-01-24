package com.example.main.Dao;

import com.example.main.Entity.Uzytkownik;

import java.util.Collection;

public interface UzytkownikDao {
    Collection<Uzytkownik> getAllUzytkownik();

    Uzytkownik getUzytkownikById(int id);

    int getUzytkownicyCount();

    void upadeUzytkownikByID(Uzytkownik uzytkownik);

    void removeUzytkownikById(int id);

    void insertUzytkownik(Uzytkownik uzytkownik);


}
