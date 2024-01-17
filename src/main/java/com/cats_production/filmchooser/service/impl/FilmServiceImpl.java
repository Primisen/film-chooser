package com.cats_production.filmchooser.service.impl;

import com.cats_production.filmchooser.dto.FilmDTO;
import com.cats_production.filmchooser.mapper.FilmMapper;
import com.cats_production.filmchooser.repository.FilmRepository;
import com.cats_production.filmchooser.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    @Override
    public List<FilmDTO> findAll() {
        return filmRepository.findAll()
                .stream()
                .map(filmMapper::filmToFilmDto)
                .collect(Collectors.toList());
    }

    @Override
    public FilmDTO add(FilmDTO filmDTO) {
        return filmMapper.filmToFilmDto(filmRepository.save(filmMapper.filmDtoToFilm(filmDTO)));
    }

    @Override
    public Optional<FilmDTO> updateById(UUID id, FilmDTO film) {
        AtomicReference<Optional<FilmDTO>> atomicReference = new AtomicReference<>();

        filmRepository.findById(id).ifPresentOrElse(foundFilm -> {
            foundFilm.setName(film.getName());
            foundFilm.setYear(film.getYear());
            atomicReference.set(Optional.of(filmMapper
                    .filmToFilmDto(filmRepository.save(foundFilm))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Boolean deleteById(UUID id) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<FilmDTO> getById(UUID id) {
        return Optional
                .ofNullable(filmMapper.filmToFilmDto(filmRepository.findById(id)
                        .orElse(null)));
    }
}
