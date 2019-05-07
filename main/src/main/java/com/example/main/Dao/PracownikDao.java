package com.example.main.Dao;

import com.example.main.Entity.Pracownik;

import java.util.Collection;

public interface PracownikDao {
    Collection<Pracownik> getAllPracownik();
     Collection<Pracownik> getAllPracownik(int id_zglosz);
    Pracownik getPracownikById(int id);
    Pracownik getPracownikByLogHas(String login,String haslo);
}
