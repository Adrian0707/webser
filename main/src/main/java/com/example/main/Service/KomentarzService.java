package com.example.main.Service;


import com.example.main.Dao.KomentarzDao;
import com.example.main.Entity.Komentarz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KomentarzService {

    @Autowired
    @Qualifier("komentarzSql")
    private KomentarzDao komentarzDao;

    public Collection<Komentarz> getAllKomentarz(int id_zglosz) {
        return komentarzDao.getAllKomentarz(id_zglosz);

    }

    public Komentarz getKomentarzById(int id) {
        return this.komentarzDao.getKomentarzById(id);
    }

    public void removeKomentarzById(int id) {
        komentarzDao.removeKomentarzById(id);
    }

    public void upadeKomentarzByID(Komentarz komentarz) {
        komentarzDao.upadeKomentarzByID(komentarz);

    }

    public void insertKomentarz(Komentarz komentarz) {
        komentarzDao.insertKomentarz(komentarz);
    }

    public int getKomentarzCount(){return this.komentarzDao.getKomentarzCount();}
}
