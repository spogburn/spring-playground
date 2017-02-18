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

    @GetMapping("/articles/{articleId}/topic/{topic}")
    public String getArticle(@PathVariable int articleId, @PathVariable String topic){
        return String.format("articleId:%d articleTopic:%s", articleId, topic);
    }

    @GetMapping("/flowers/{variety}/{color}/{quantity}")
    public String getFlowers(@PathVariable Map pathVariables){
        return pathVariables.toString();
    }

    @GetMapping("/candy/{type}/{flavor}/{quantity}")
    public String getCandies(Candy candy) {
        return String.format("Candy type is %s; flavor is %s; quantity is %d", candy.getType(), candy.getFlavor(), candy.getQuantity());
    }


}
