package com.cats_production.filmchooser.mapper;

import com.cats_production.filmchooser.model.FilmDTO;
import com.cats_production.filmchooser.entity.Film;
import org.mapstruct.Mapper;

@Mapper
public interface FilmMapper {

    Film  filmDtoToFilm(FilmDTO dto);

    FilmDTO filmToFilmDto(Film film);
}
