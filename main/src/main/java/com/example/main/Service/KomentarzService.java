package com.example.main.Service;


import com.example.main.Dao.KomentarzDao;
import com.example.main.Dao.StudentDao;
import com.example.main.Entity.Komentarz;
import com.example.main.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KomentarzService {

    @Autowired
    @Qualifier("komentarzSql")
    private KomentarzDao komentarzDao;

    public Collection<Komentarz> getAllKomentarz() {
        return komentarzDao.getAllKomentarz();

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

}
