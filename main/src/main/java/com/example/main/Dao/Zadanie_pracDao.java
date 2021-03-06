package com.example.main.Dao;


import com.example.main.Entity.Zadanie_prac;

import java.util.Collection;

public interface Zadanie_pracDao {
    Collection<Zadanie_prac> getAllZadanie_prac();

    Zadanie_prac getZadanie_pracById(int id,int id2);

    void upadeZadanie_pracById(Zadanie_prac zadanie_prac);

    void removeZadanie_pracById(int id1, int id2);

    void insertZadanie_prac(Zadanie_prac zadanie_prac);

    int getZadanie_pracCount();
}
