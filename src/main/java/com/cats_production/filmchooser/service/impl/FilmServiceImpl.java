package com.cats_production.filmchooser.service.impl;

import com.cats_production.filmchooser.domain.Film;
import com.cats_production.filmchooser.repository.FilmRepository;
import com.cats_production.filmchooser.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
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
    public Film add(Film film) {
        Film savedFilm = filmRepository.save(film);
        return savedFilm;
    }

    @Override
    public void updateById(UUID id, Film film) {
        Film existing = filmRepository.findById(film.getId()).orElseThrow(() -> new RuntimeException());
        existing.setName(film.getName());
        existing.setYear(film.getYear());

        filmRepository.save(existing);
    }
}
