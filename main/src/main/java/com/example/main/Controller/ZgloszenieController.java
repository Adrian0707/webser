package com.example.main.Controller;


import com.example.main.Entity.Zgloszenie;
import com.example.main.Service.ZgloszenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@CrossOrigin
@RequestMapping("/Zgloszenia")
public class ZgloszenieController {
    @Autowired
    private ZgloszenieService zgloszenieService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Zgloszenie> getAllZgloszenie() {
        return zgloszenieService.getAllZgloszenie();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zgloszenie getZgloszenieById(@PathVariable("id") int id) {
        return zgloszenieService.getZgloszenieById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletZgloszenieById(@PathVariable("id") int id) {
        zgloszenieService.removeZgloszenieById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpadeZgloszenieById(@RequestBody Zgloszenie zgloszenie) {
        zgloszenieService.upadeZgloszenieByID(zgloszenie);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertZgloszenie(@RequestBody Zgloszenie zgloszenie) {
        zgloszenieService.insertZgloszenie(zgloszenie);
    }

}
