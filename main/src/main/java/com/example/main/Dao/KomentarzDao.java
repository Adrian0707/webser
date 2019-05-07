package com.example.main.Dao;

import com.example.main.Entity.Komentarz;

import java.util.Collection;

public interface KomentarzDao {
    Collection<Komentarz> getAllKomentarz(int id_zglosz);

    Komentarz getKomentarzById(int id);

    void upadeKomentarzByID(Komentarz komentarz);

    void removeKomentarzById(int id);

    void insertKomentarz(Komentarz komentarz);

    int getKomentarzCount();
}
