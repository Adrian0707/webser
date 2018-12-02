package com.example.main.Controller;


import com.example.main.Entity.Komentarz;
import com.example.main.Service.KomentarzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/Komentarze")
public class KomentarzController {
    @Autowired
    private KomentarzService komentarzService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Komentarz> getAllKomentarz() {
        return komentarzService.getAllKomentarz();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Komentarz getKomentarzById(@PathVariable("id") int id) {
        return komentarzService.getKomentarzById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletKomentarzById(@PathVariable("id") int id) {
        komentarzService.removeKomentarzById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpadeKomentarzById(@RequestBody Komentarz komentarz) {
        komentarzService.upadeKomentarzByID(komentarz);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertKomentarz(@RequestBody Komentarz komentarz) {
        komentarzService.insertKomentarz(komentarz);
    }

}
