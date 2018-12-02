package com.example.main.Dao;

import com.example.main.Entity.Zgloszenie;

import java.util.Collection;

public interface ZgloszenieDao {
    Collection<Zgloszenie> getAllZgloszenie();

    Zgloszenie getZgloszenieById(int id);

    void upadeZgloszenieByID(Zgloszenie zgloszenie);

    void removeZgloszenieById(int id);

    void insertZgloszenie(Zgloszenie zgloszenie);
}
