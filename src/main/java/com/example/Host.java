package com.example;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */
public class Host {
    private String name;
    private int id;

    public Host(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
