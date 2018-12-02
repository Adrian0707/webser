package com.example.main.Controller;

import com.example.main.Entity.Priorytet;
import com.example.main.Service.PriorytetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Priorytety")
public class PriorytetController {


    @Autowired
    private PriorytetService priorytetService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Priorytet> getAllPriorytet() {
        return priorytetService.getAllPriorytet();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Priorytet getPriorytetById(@PathVariable("id") int id) {
        return priorytetService.getPriorytetById(id);
    }


}
