package com.breizh.challenge.controller;
import com.breizh.challenge.model.Village;
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

public class VillageController {


    //Appel repo JPA
    @Autowired
    private VillageRepository villageRepository;


    //Get liste villages
    @CrossOrigin
    @GetMapping(value= "/Village")
    List<Village> allVillage() {
        return villageRepository.findAll();
    }


    //Get village par ID
    @CrossOrigin
    @GetMapping(value= "/Village/{id}")
    public Optional<Village> villageById(@PathVariable int id){
        return villageRepository.findById(id);
    }

    //Insert un village
    @CrossOrigin
    @PostMapping(value = "/Village")
    public ResponseEntity<Void> createVillage(@RequestBody Village village) {
        Village savedVillage = villageRepository.save(village);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedVillage.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Update un village
    @CrossOrigin
    @PutMapping(value= "/Village")
    public void updateVillage(@RequestBody Village village ) {
        villageRepository.save(village);
    }


    //Delete un village
    @CrossOrigin
    @DeleteMapping(value= "/Village/{id}")
    public void deleteVillage(@PathVariable int id){
        villageRepository.deleteById(id);
    }
}
