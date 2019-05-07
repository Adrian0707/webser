package com.example.main.Dao;

import com.example.main.Entity.Kategoria;


import java.util.Collection;

public interface KategoriaDao {

    Collection<Kategoria> getAllKategoria();

    Kategoria getKategoriaById(int id);


}
