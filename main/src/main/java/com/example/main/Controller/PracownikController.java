package com.example.main.Controller;

import com.example.main.Entity.Pracownik;
import com.example.main.Service.PracownikService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
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
