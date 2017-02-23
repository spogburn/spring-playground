package com.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by stephaniepaigeogburn on 2/22/17.
 */


@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    private String name;
    private String bandName;

    public void setName(String name) {
        this.name = name;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getName() {

        return name;
    }

    public String getBandName() {
        return bandName;
    }
}
