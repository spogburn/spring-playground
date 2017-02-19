package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */

@RestController
@RequestMapping("/json")

public class JSONController {

    @PostMapping("/person")
    public String getJSONData(@RequestBody Person person){
        return person.getFirstName() + " " + person.getLastName();
    }

    @PostMapping("/data")
    public Reporters[] getLocalData(@RequestBody Reporters reporters) {return reporters.getReporters();}

    @PostMapping("/filter/person")
    public Reporters[] getNestedData(@RequestBody Reporters reporters){
        return reporters.getReporters();
    }

}
