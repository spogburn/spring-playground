package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by stephaniepaigeogburn on 2/22/17.
 */
public interface AlbumRepository extends CrudRepository<Album, Long> {
    Iterable<Album> findAll();
}
