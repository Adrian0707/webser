package com.example.main.Controller;


import com.example.main.Entity.Uzytkownik;
import com.example.main.Service.Mail;
import com.example.main.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@CrossOrigin
@RequestMapping("/Uzytkownicy")
public class UzytkownikController {
    @Autowired
    private UzytkownikService uzytkownikService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Uzytkownik> getAllUzytkownik() {
        return uzytkownikService.getAllUzytkownik();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Uzytkownik getUzytkownikById(@PathVariable("id") int id) {
        return uzytkownikService.getUzytkownikById(id);
    }
    @RequestMapping(value = "/{login}/{haslo}", method = RequestMethod.GET)
    public Uzytkownik getUzytkownikByLogHas(@PathVariable("login") String login, @PathVariable("haslo") String haslo) {
        return uzytkownikService.getUzytkownikByLogHas(login,haslo);
    }
    @RequestMapping(value = "/{login}/get", method = RequestMethod.GET)
    public Uzytkownik getUzytkownikByLog(@PathVariable("login") String login) {
        return uzytkownikService.getUzytkownikByLog(login);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getUzytkownicyCount(){return uzytkownikService.getUzytkownicyCount();}

   /* @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletUzytkownikById(@PathVariable("id") int id) {
        uzytkownikService.removeUzytkownikById(id);
    }*/

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpadeUzytkownikById(@RequestBody Uzytkownik uzytkownik) {
        uzytkownikService.upadeUzytkownikByID(uzytkownik);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUzytkownik(@RequestBody Uzytkownik uzytkownik) {
        uzytkownikService.insertUzytkownik(uzytkownik);
    }

}
