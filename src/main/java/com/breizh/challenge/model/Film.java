package com.breizh.challenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String titre;
    String description;
    String releaseYear;
    int length;
}
