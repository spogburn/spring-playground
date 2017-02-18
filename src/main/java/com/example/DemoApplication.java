package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication

@RestController
public class DemoApplication {

    @DeleteMapping("/delete")
    public String deleteData(){
        return "deleted!";
    }
	@PutMapping("/put")
    public String updateData(){
	    return "you just updated some data!";
    }


}
