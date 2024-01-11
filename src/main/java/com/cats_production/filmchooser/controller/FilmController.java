package com.cats_production.filmchooser.controller;

import com.cats_production.filmchooser.domain.Film;
import com.cats_production.filmchooser.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addFilm(@RequestBody Film film) {
        filmService.add(film);
    }
}
