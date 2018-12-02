package com.example.main.Dao;

import com.example.main.Entity.Komentarz;
import com.example.main.Entity.Student;

import java.util.Collection;

public interface KomentarzDao {
    Collection<Komentarz> getAllKomentarz();

    Komentarz getKomentarzById(int id);

    void upadeKomentarzByID(Komentarz komentarz);

    void removeKomentarzById(int id);

    void insertKomentarz(Komentarz komentarz);
}
