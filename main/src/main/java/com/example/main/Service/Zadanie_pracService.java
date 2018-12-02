package com.example.main.Service;


import com.example.main.Dao.Zadanie_pracDao;

import com.example.main.Entity.Zadanie_prac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Zadanie_pracService {


    @Autowired
    @Qualifier("zadanie_pracSql")
    private Zadanie_pracDao zadaniePracDao;

    public Collection<Zadanie_prac> getAllZadanie_prac() {
        return zadaniePracDao.getAllZadanie_prac();

    }

    public Zadanie_prac getZadanie_pracById(int id) {
        return this.zadaniePracDao.getZadanie_pracById(id);
    }

    public void removeZadanie_pracById(int id) {
        zadaniePracDao.removeZadanie_pracById(id);
    }

    public void upadeZadanie_pracById(Zadanie_prac zadanie_prac) {
        zadaniePracDao.upadeZadanie_pracById(zadanie_prac);

    }

    public void insertZadanie_prac(Zadanie_prac zadanie_prac) {
        zadaniePracDao.insertZadanie_prac(zadanie_prac);
    }

}



