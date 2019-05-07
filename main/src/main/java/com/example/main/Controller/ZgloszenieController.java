package com.example.main.Controller;


import com.example.main.Entity.Pracownik;
import com.example.main.Entity.Uzytkownik;
import com.example.main.Entity.Zgloszenie;
import com.example.main.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.ZoneId;
import java.util.Collection;


@RestController
@CrossOrigin
@RequestMapping("/Zgloszenia")
public class ZgloszenieController {
    @Autowired
    private ZgloszenieService zgloszenieService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private PriorytetService priorytetService;
    @Autowired
    private KaterogiaService katerogiaService;
    @Autowired
    private PracownikService pracownikService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Zgloszenie> getAllZgloszenie() {
        return zgloszenieService.getAllZgloszenie();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Zgloszenie getZgloszenieById(@PathVariable("id") int id) {
        return zgloszenieService.getZgloszenieById(id);
    }

    @RequestMapping(value = "/uz.{id}", method = RequestMethod.GET)
    public Collection<Zgloszenie> getZgloszenieByIdUz(@PathVariable("id") int idUz) {
        return zgloszenieService.getZgloszeniaByIdUz(idUz);
    }
    @RequestMapping(value = "/id_prac/{id_prac}", method = RequestMethod.GET)
    public Collection<Zgloszenie> getAllPracownik(@PathVariable("id_prac") int id_prac) {
        return zgloszenieService.getAllPracownik(id_prac);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletZgloszenieById(@PathVariable("id") int id) {
        zgloszenieService.removeZgloszenieById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void UpadeZgloszenieById(@RequestBody Zgloszenie zgloszenie) {
        Mail mail = new Mail();
        Uzytkownik user =uzytkownikService.getUzytkownikById(zgloszenie.getId_uzyt());
        mail.sendMessage(user.getEmail(),"Zmiana Statusu" +
                "","Witaj "+user.getImie()+" "+user.getNazwisko()+"\ntwojgo zgłoszenie: #"+zgloszenie.getId_zglosz()+
                " "+zgloszenie.getNazwa()+" uległo zmianie\n" +
                "Status:"+statusService.getStatusById(zgloszenie.getId_status()).getNazwa()+"\n"
        +"Priorytet:"+priorytetService.getPriorytetById(zgloszenie.getId_priorytet()).getNazwa()+"\n"
        +"Kategoria:"+katerogiaService.getKategoriaById(zgloszenie.getId_status()).getNazwa()+"\n"
        +"Wiecej informacji znajdziesz na stronie http://localhost:4200");
        zgloszenieService.upadeZgloszenieByID(zgloszenie);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertZgloszenie(@RequestBody Zgloszenie zgloszenie) {
        zgloszenie.setData_max( new Date(Date.from(zgloszenie.getData_przyj()
                .toLocalDate().plusDays(20).atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()));

        Mail mail = new Mail();
        Collection<Pracownik> employees =pracownikService.getAllPracownik();
        for (Pracownik employee : employees) {
            if(employee.getNadzorca()==true){
                mail.sendMessage(employee.getEmail(),"Nowe zgłoszenie" +
                        "","Odnotowano nowe zgłoszenie nr: "+zgloszenie.getId_zglosz()+"\n"
                +"Nazwa :"+zgloszenie.getNazwa()+"\n"
                +"Maksymalna data jego realizaji została ustanowiona na "+zgloszenie.getData_max()+"\n"
                +"Wiecej na http://localhost:4200");
            }

        }


        zgloszenieService.insertZgloszenie(zgloszenie);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getZgloszenieCount(){return zgloszenieService.getZgloszenieCount();}

}
