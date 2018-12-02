package com.example.main.Controller;

import com.example.main.Entity.Pracownik;
import com.example.main.Entity.Student;
import com.example.main.Service.PracownikService;
import com.example.main.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pracownicy")
public class PracownikController {


    @Autowired
    private PracownikService pracownikService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Pracownik> getAllPracownik() {
        return pracownikService.getAllPracownik();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pracownik getPraconikById(@PathVariable("id") int id) {
        return pracownikService.getPracownikById(id);
    }


}
