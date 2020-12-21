package com.breizh.challenge.model;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int releaseDate;

    @ManyToOne
    @JoinColumn
    Village village;
}
