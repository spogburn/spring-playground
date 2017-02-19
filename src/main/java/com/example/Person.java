package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by stephaniepaigeogburn on 2/18/17.
 */
public class Person {
    private String firstName;
    private String lastName;

    @JsonProperty("first_name")
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName(){
        return lastName;
    }

    public void setLastName(){
        this.lastName = lastName;
    }




}
