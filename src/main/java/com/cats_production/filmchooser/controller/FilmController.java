package com.cats_production.filmchooser.controller;

import com.cats_production.filmchooser.domain.Film;
import com.cats_production.filmchooser.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public Iterable<Film> getFilms() {
        return filmService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addFilm(@RequestBody Film film) {
        Film savedFilm = filmService.add(film);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/films" + savedFilm.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") UUID id, @RequestBody Film film) {

        filmService.updateById(id, film);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {

        filmService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
