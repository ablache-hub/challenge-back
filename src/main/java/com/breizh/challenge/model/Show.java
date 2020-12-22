package com.breizh.challenge.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
public @Data class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String releaseDate;

    @ManyToOne
    @JoinColumn(name = "village_id")
    Village village;

    public Show(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public Show() {

    }

    public Show(String releaseDate, Village village) {
        this.releaseDate = releaseDate;
        this.village = village;
    }
}

