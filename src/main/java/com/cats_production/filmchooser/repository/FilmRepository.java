package com.cats_production.filmchooser.repository;

import com.cats_production.filmchooser.dto.FilmDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends CrudRepository<FilmDTO, UUID> {
}
