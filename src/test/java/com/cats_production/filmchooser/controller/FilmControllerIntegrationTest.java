package com.cats_production.filmchooser.controller;

import com.cats_production.filmchooser.dto.FilmDTO;
import com.cats_production.filmchooser.entity.Film;
import com.cats_production.filmchooser.repository.FilmRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmControllerIntegrationTest {

    @Autowired
    FilmController filmController;

    @Autowired
    FilmRepository filmRepository;

//    @Test
//    void testGetFilms() {
//        List<FilmDTO> dtos = filmController.getFilms();
//
//        assertThat(dtos.size()).isEqualTo(3);
//    }

//    @Rollback
//    @Transactional
//    @Test
//    void testEmptyList() {
//        filmRepository.deleteAll();
//        List<FilmDTO>  dtos = filmController.getFilms();
//
//        assertThat(dtos.size()).isEqualTo(0);
//    }

//    @Rollback
//    @Transactional
//    @Test
//    void saveNewBeerTest() {
//        FilmDTO filmDTO = FilmDTO.builder()
//                .name("Test")
//                .build();
//
//        ResponseEntity<String> responseEntity = filmController.addFilm(filmDTO);
//
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
//        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();
//
//        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
//        UUID savedUUID = UUID.fromString(locationUUID[4]);
//
//        Film film = filmRepository.findById(savedUUID).get();
//        assertThat(film).isNotNull();
//    }
}