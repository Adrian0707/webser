package com.example.main.Dao;

import com.example.main.Entity.Status;

import java.util.Collection;

public interface StatusDao {

    Collection<Status> getAllStatus();

    Status getStatusById(int id);


}
