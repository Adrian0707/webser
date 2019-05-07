package com.example.main.Dao;

import com.example.main.Entity.Zgloszenie;

import java.util.Collection;

public interface ZgloszenieDao {
    Collection<Zgloszenie> getAllZgloszenie();

    Zgloszenie getZgloszenieById(int id);
    Collection<Zgloszenie> getZgloszeniaByIdUz(int idUz);

    void upadeZgloszenieByID(Zgloszenie zgloszenie);

    void removeZgloszenieById(int id);
    Collection<Zgloszenie> getAllZgloszenie(int id_prac);
    void insertZgloszenie(Zgloszenie zgloszenie);
    int getZgloszenieCount();
}
