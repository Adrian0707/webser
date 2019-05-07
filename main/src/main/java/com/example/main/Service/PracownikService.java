package com.example.main.Service;

import com.example.main.Dao.PracownikDao;

import com.example.main.Entity.Pracownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PracownikService {
    @Autowired
    @Qualifier("pracownikSql")
    private PracownikDao pracownikDao;

    public Collection<Pracownik> getAllPracownik() {
        return pracownikDao.getAllPracownik();

    }
    public Collection<Pracownik> getAllPracownik(int id_zglosz) {
        return pracownikDao.getAllPracownik(id_zglosz);

    }

    public Pracownik getPracownikById(int id) {
        return this.pracownikDao.getPracownikById(id);
    }

    public Pracownik getPracownikByLogHas(String login,String haslo){return this.pracownikDao.getPracownikByLogHas(login,haslo);}
}
