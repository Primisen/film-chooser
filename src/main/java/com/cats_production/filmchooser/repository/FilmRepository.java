package com.cats_production.filmchooser.repository;

import com.cats_production.filmchooser.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
}
