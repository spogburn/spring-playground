package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/cats")
    public String getCats(
            @RequestParam String name, @RequestParam String breed)
    {
        return String.format("Cat name is " + name + " and breed is " + breed);
    }

    @GetMapping("/dogs")
    public String getDogs(@RequestParam Map querystring){
        return querystring.toString();
    }

    @GetMapping("/shows")
    public String getShows(Shows shows){
        return String.format("show name is %s; show genre is %s", shows.getShowName(), shows.getShowGenre());
    }

}
