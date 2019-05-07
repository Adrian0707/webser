package com.example.main.Service;

import com.example.main.Dao.PriorytetDao;
import com.example.main.Entity.Priorytet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PriorytetService {

    @Autowired
    @Qualifier("priorytetSql")
    private PriorytetDao priorytetDao;

    public Collection<Priorytet> getAllPriorytet() {
        return priorytetDao.getAllPriorytet();

    }

    public Priorytet getPriorytetById(int id) {
        return this.priorytetDao.getPriorytetById(id);
    }

}
