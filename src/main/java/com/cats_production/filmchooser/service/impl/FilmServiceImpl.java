package com.cats_production.filmchooser.service.impl;

import com.cats_production.filmchooser.domain.Film;
import com.cats_production.filmchooser.repository.FilmRepository;
import com.cats_production.filmchooser.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public void add(Film film) {
        filmRepository.save(film);
    }
}
