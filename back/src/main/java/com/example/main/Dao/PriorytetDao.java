package com.example.main.Dao;

import com.example.main.Entity.Priorytet;

import java.util.Collection;

public interface PriorytetDao {

    Collection<Priorytet> getAllPriorytet();

    Priorytet getPriorytetById(int id);


}
