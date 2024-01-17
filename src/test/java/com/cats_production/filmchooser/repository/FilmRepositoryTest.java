package com.cats_production.filmchooser.repository;

import com.cats_production.filmchooser.entity.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FilmRepositoryTest {

    @Autowired
    FilmRepository filmRepository;

    @Test
    void testSaveFilm() {
        Film savedFilm = filmRepository.save(Film.builder()
                        .name("Test")
                .build());

        assertThat(savedFilm).isNotNull();
        assertThat(savedFilm.getId()).isNotNull();
    }
}