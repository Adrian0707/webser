package com.example.main.Service;

import com.example.main.Dao.KategoriaDao;
import com.example.main.Dao.StatusDao;
import com.example.main.Entity.Kategoria;
import com.example.main.Entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StatusService {

    @Autowired
    @Qualifier("statusSql")
    private StatusDao statusDao;

    public Collection<Status> getAllStatus() {
        return statusDao.getAllStatus();

    }

    public Status getStatusById(int id) {
        return this.statusDao.getStatusById(id);
    }

}
