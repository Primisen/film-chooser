package com.cats_production.filmchooser.repository;

import com.cats_production.filmchooser.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends CrudRepository<Film, UUID> {
}
