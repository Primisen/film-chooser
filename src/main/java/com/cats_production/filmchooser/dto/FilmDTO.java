package com.cats_production.filmchooser.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FilmDTO {
    private UUID id;
    private String name;
    private Date year;
}
