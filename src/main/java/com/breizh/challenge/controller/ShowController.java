package com.breizh.challenge.controller;
import com.breizh.challenge.model.Show;
import com.breizh.challenge.model.Village;
import com.breizh.challenge.repository.ShowRepository;
import com.breizh.challenge.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {


    //Appel repo JPA
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private VillageRepository villageRepository;

    //Get liste show
    @CrossOrigin
    @GetMapping(value= "/Show")
    List<Show> allShow() {
        return showRepository.findAll();
    }


    //Get show par ID
    @CrossOrigin
    @GetMapping(value= "/Show/{id}")
    public Optional<Show> showById(@PathVariable int id){
        return showRepository.findById(id);
    }

    //Créer un show
    @CrossOrigin
    @PostMapping(value = "/Show")
    public ResponseEntity<Void> createShow(@RequestBody Show show) {
        Show savedShow = showRepository.save(show);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedShow.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Créer Show AVEC village
    @CrossOrigin
    @PostMapping("/Show/{villageId}")
    public Show createShow(@PathVariable Integer villageId, @RequestBody Show show) {
        Optional<Village> village = villageRepository.findById(villageId);
        if(villageId != null){
            show.setVillage(village.get());
            showRepository.save(show);
            return show;
        }
        return null;
    }

    //Update un show
    @CrossOrigin
    @PutMapping(value= "/Show")
    public void updateShow(@RequestBody Show show ) {
        showRepository.save(show);
    }




    //Delete un village
    @CrossOrigin
    @DeleteMapping(value= "/Show/{id}")
    public void deleteShow(@PathVariable int id){
        showRepository.deleteById(id);
    }
}
