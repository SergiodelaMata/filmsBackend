package com.practices.sergiodelamata.filmsBackend.service;

import com.practices.sergiodelamata.filmsBackend.model.Film;

import java.sql.Date;
import java.util.List;

public interface IFilmService {
    List<Film> searchAll();

    Film searchFilmById(Integer idFilm);

    List<Film> searchFilmsByTitle(String title);

    List<Film> searchFilmsByYear(Date dateInit, Date dateEnd);

    List<Film> searchFilmsByCountry(String country);

    List<Film> searchFilmsByDirection(String direction);

    List<Film> searchFilmsByGenres(String genres);

    void saveFilm(Film film);

    void deleteFilm(Integer idFilm);

    void updateFilm(Film film);
}
