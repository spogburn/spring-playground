package com.example;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */
public class Program {

    private String name;
    private Host[] hosts;

    public Program(String name, Host[] hosts){
        this.name = name;
        this.hosts = hosts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Host[] getHosts() {
        return hosts;
    }

    public void setHosts(Host[] hosts) {
        this.hosts = hosts;
    }
}
