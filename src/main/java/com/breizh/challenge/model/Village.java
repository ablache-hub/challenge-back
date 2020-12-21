package com.breizh.challenge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Village {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String name;
    private int postCode;

    @OneToMany(mappedBy = "village")
    @JsonBackReference
    private List<Show> shows;

    public Village(String name, int postCode) {
        this.name = name;
        this.postCode = postCode;
    }

    public Village() {

    }
}
