package com.example.main.Dao;

import com.example.main.Entity.Pracownik;
import com.example.main.Entity.Student;

import java.util.Collection;

public interface PracownikDao {
    Collection<Pracownik> getAllPracownik();

    Pracownik getPracownikById(int id);
}
