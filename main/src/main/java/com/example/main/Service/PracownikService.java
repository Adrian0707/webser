package com.example.main.Service;

import com.example.main.Dao.PracownikDao;
import com.example.main.Dao.StudentDao;
import com.example.main.Entity.Pracownik;
import com.example.main.Entity.Student;
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

    public Pracownik getPracownikById(int id) {
        return this.pracownikDao.getPracownikById(id);
    }


}
