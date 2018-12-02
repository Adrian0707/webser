package com.example.main.Service;

import com.example.main.Dao.KategoriaDao;
import com.example.main.Entity.Kategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KaterogiaService {

    @Autowired
    @Qualifier("kategoriaSql")
    private KategoriaDao kategoriaDao;

    public Collection<Kategoria> getAllKategoria() {
        return kategoriaDao.getAllKategoria();

    }

    public Kategoria getKategoriaById(int id) {
        return this.kategoriaDao.getKategoriaById(id);
    }

}
