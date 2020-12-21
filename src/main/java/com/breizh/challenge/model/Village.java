package com.breizh.challenge.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class Village {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;
    private int postCode;

    public Village(String name, int postCode) {
        this.name = name;
        this.postCode = postCode;
    }

    public Village() {

    }
}
