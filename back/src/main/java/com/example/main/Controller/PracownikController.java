package com.example.main.Controller;

import com.example.main.Entity.Pracownik;
import com.example.main.Service.PracownikService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/Pracownicy")
public class PracownikController {


    @Autowired
    private PracownikService pracownikService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Pracownik> getAllPracownik() {
        return pracownikService.getAllPracownik();
    }

    @RequestMapping(value = "/id_zglosz/{id_zglosz}", method = RequestMethod.GET)
    public Collection<Pracownik> getAllPracownik(@PathVariable("id_zglosz") int id_zglosz) {
        return pracownikService.getAllPracownik(id_zglosz);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pracownik getPracownikById(@PathVariable("id") int id) {
        return pracownikService.getPracownikById(id);
    }

    @RequestMapping(value = "/{login}/{haslo}", method = RequestMethod.GET)
    public Pracownik getPracownikByLogHas(@PathVariable("login") String login, @PathVariable("haslo") String haslo) {
        return pracownikService.getPracownikByLogHas(login,haslo);
    }


}
