package com.cats_production.filmchooser.service;

import com.cats_production.filmchooser.domain.Film;

import java.util.UUID;

public interface FilmService {

    Iterable<Film> findAll();

    Film add(Film film);

    void updateById(UUID id, Film film);

    void deleteById(UUID id);
}
