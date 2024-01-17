package com.cats_production.filmchooser.service.impl;

import com.cats_production.filmchooser.dto.FilmDTO;
import com.cats_production.filmchooser.exception.NotFoundException;
import com.cats_production.filmchooser.repository.FilmRepository;
import com.cats_production.filmchooser.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Iterable<FilmDTO> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public FilmDTO add(FilmDTO filmDTO) {
        FilmDTO savedFilmDTO = filmRepository.save(filmDTO);
        return savedFilmDTO;
    }

    @Override
    public void updateById(UUID id, FilmDTO filmDTO) {
        FilmDTO existing = filmRepository.findById(filmDTO.getId()).orElseThrow(NotFoundException::new);
        existing.setName(filmDTO.getName());
        existing.setYear(filmDTO.getYear());

        filmRepository.save(existing);
    }

    @Override
    public void deleteById(UUID id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Optional<FilmDTO> getById(UUID id) {
        return filmRepository.findById(id);
    }
}
