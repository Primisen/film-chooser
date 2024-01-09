package com.cats_production.filmchooser.service;

import com.cats_production.filmchooser.domain.Film;

public interface FilmService {

    Iterable<Film> findAll();
}
