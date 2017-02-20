package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by stephaniepaigeogburn on 2/19/17.
 */

@RestController

public class JSONRenderController {

    @GetMapping("/data")
    public Reporter getReporter(){
        Reporter reporter = new Reporter("Ari", "Shapiro");
        return reporter;
    }


    @GetMapping("/data/nested")
        public Program getHosts() {
        Host[] hosts = new Host[]{
                new Host("Rachel Martin", 1), new Host("Ari Shapiro", 2)
        };
        Program program = new Program("All Things Considered", hosts);
        return program;
    }

}
