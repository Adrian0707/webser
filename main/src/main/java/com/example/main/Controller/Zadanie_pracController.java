package com.example.main.Controller;

import com.example.main.Entity.Student;
import com.example.main.Entity.Zadanie_prac;
import com.example.main.Service.StudentService;
import com.example.main.Service.Zadanie_pracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/zadania_prac")
public class Zadanie_pracController {


    @Autowired
    private Zadanie_pracService zadanie_pracService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Zadanie_prac> getAllZadanie_prac() {
        return zadanie_pracService.getAllZadanie_prac();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zadanie_prac getZadanie_pracById(@PathVariable("id") int id) {
        return zadanie_pracService.getZadanie_pracById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteZadanie_pracById(@PathVariable("id") int id) {
        zadanie_pracService.removeZadanie_pracById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpadeStudentById(@RequestBody Zadanie_prac zadanie_prac) {
        zadanie_pracService.upadeZadanie_pracById(zadanie_prac);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertZadanie_prac(@RequestBody Zadanie_prac zadanie_prac) {
        zadanie_pracService.insertZadanie_prac(zadanie_prac);
    }

}


