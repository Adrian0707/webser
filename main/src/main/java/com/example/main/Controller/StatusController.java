package com.example.main.Controller;


import com.example.main.Entity.Status;
import com.example.main.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Statusy")
public class StatusController {


    @Autowired
    private StatusService statusService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Status getStatusById(@PathVariable("id") int id) {
        return statusService.getStatusById(id);
    }


}
