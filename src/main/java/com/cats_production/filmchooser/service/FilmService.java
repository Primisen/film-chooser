package com.cats_production.filmchooser.service;

import com.cats_production.filmchooser.dto.FilmDTO;

import java.util.Optional;
import java.util.UUID;

public interface FilmService {

    Iterable<FilmDTO> findAll();

    FilmDTO add(FilmDTO filmDTO);

    void updateById(UUID id, FilmDTO filmDTO);

    void deleteById(UUID id);

    Optional<FilmDTO> getById(UUID id);
}
