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

    public Uzytkownik getUzytkownikByLogHas(String login,String haslo){return this.uzytkownikDao.getUzytkownikByLogHas(login,haslo);}

    public Uzytkownik getUzytkownikByLog(String login){return this.uzytkownikDao.getUzytkownikByLog(login);}

    public void removeUzytkownikById(int id) {
        this.uzytkownikDao.removeUzytkownikById(id);
    }

    public void upadeUzytkownikByID(Uzytkownik uzytkownik) {
        this.uzytkownikDao.upadeUzytkownikByID(uzytkownik);

    }

    public void insertUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownikDao.insertUzytkownik(uzytkownik);
    }



}
