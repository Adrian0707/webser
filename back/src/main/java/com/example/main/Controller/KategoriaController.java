package com.example.main.Controller;

import com.example.main.Entity.Kategoria;
import com.example.main.Service.KaterogiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/Kategorie")
public class KategoriaController {


    @Autowired
    private KaterogiaService katerogiaService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Kategoria> getAllKategoria() {
        return katerogiaService.getAllKategoria();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Kategoria getKategoriaById(@PathVariable("id") int id) {
        return katerogiaService.getKategoriaById(id);
    }


}
