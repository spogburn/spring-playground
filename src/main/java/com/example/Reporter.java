package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by stephaniepaigeogburn on 2/18/17.
 */
public class Reporter {
    private String firstName;
    private String lastName;

    public Reporter(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty("first_name")
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }




}
