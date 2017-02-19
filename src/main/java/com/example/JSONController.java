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
    public String getJSONData(@RequestBody Reporter reporter){
        return reporter.getFirstName() + " " + reporter.getLastName();
    }

    @PostMapping("/data")
    public String getLocalData(@RequestBody Reporters reporters) {return reporters.getReporters()[0].getFirstName() + " " + reporters.getReporters()[0].getLastName();}

    @PostMapping("/filter/person")
    public Reporter[] getNestedData(@RequestBody Reporters reporters){
        return reporters.getReporters();
    }

}
