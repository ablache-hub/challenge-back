package com.breizh.challenge.controller;
import com.breizh.challenge.model.Village;
import com.breizh.challenge.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController

public class VillageController {

    @Autowired
    private VillageRepository villageRepository;


    @CrossOrigin
    @GetMapping(value="/Village")
    List<Village> allVillage() {
        return villageRepository.findAll();
    }


    @CrossOrigin
    @GetMapping(value="/Village/{id}")
    public Optional<Village> villageById(@PathVariable int id){


        return villageRepository.findById(id);


    }
}
