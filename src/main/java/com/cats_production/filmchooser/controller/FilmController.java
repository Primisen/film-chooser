package com.cats_production.filmchooser.controller;

import com.cats_production.filmchooser.exception.NotFoundException;
import com.cats_production.filmchooser.model.Film;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class FilmController {

    public static final String FILMS_PATH = "/api/v1/films";
    public static final String FILMS_PATH_ID = FILMS_PATH + "/{id}";

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(FILMS_PATH)
    public Iterable<Film> getFilms() {
        return filmService.findAll();
    }

    @GetMapping(FILMS_PATH_ID)
    public Film getById(@PathVariable UUID id) {
        return filmService.getById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping(FILMS_PATH)
    public ResponseEntity<String> addFilm(@RequestBody Film film) {
        Film savedFilm = filmService.add(film);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/films" + savedFilm.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(FILMS_PATH_ID)
    public ResponseEntity<String> updateById(@PathVariable("id") UUID id, @RequestBody Film film) {

        filmService.updateById(id, film);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(FILMS_PATH_ID)
    public ResponseEntity<String> deleteById(@PathVariable("id") UUID id) {

        filmService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
