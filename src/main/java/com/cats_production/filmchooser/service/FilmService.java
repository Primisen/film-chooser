package com.cats_production.filmchooser.service;

import com.cats_production.filmchooser.model.FilmDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FilmService {

    List<FilmDTO> findAll();

    FilmDTO add(FilmDTO filmDTO);

    Optional<FilmDTO> updateById(UUID id, FilmDTO filmDTO);

    Boolean deleteById(UUID id);

    Optional<FilmDTO> getById(UUID id);
}
