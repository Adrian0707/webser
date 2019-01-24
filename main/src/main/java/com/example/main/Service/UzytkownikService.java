package com.example.main.Service;

import com.example.main.Dao.UzytkownikDao;
import com.example.main.Entity.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UzytkownikService {

    @Autowired
    @Qualifier("uzytkownikSql")
    private UzytkownikDao uzytkownikDao;

    public Collection<Uzytkownik> getAllUzytkownik() {
        return uzytkownikDao.getAllUzytkownik();

    }

    public Uzytkownik getUzytkownikById(int id) {
        return this.uzytkownikDao.getUzytkownikById(id);
    }

    public int getUzytkownicyCount(){return this.uzytkownikDao.getUzytkownicyCount();}

    public void removeUzytkownikById(int id) {
        uzytkownikDao.removeUzytkownikById(id);
    }

    public void upadeUzytkownikByID(Uzytkownik uzytkownik) {
        uzytkownikDao.upadeUzytkownikByID(uzytkownik);

    }

    public void insertUzytkownik(Uzytkownik uzytkownik) {
        uzytkownikDao.insertUzytkownik(uzytkownik);
    }


}
