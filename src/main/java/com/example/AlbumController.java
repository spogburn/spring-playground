package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by stephaniepaigeogburn on 2/22/17.
 */

@RestController
public class AlbumController {

    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository){
        this.repository = repository;
    }

    @GetMapping("/albums")
    public Iterable getAlbums(){
        return this.repository.findAll();
    }

    @PostMapping("/albums")
    public Album create(@RequestBody Album album){
        this.repository.save(album);
        return album;
    }
}
