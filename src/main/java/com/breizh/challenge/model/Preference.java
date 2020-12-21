package com.breizh.challenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public @Data class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int vote;
}
