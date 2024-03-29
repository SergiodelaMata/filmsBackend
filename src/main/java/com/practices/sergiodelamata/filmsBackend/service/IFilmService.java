package com.practices.sergiodelamata.filmsBackend.service;

import com.practices.sergiodelamata.filmsBackend.model.Film;

import java.util.List;

public interface IFilmService {
    List<Film> searchAll();

    Film searchFilmById(Integer idFilm);

    List<Film> searchFilmsByTitle(String title);

    List<Film> searchFilmsByYear(Integer yearInit, Integer yearEnd);

    List<Film> searchFilmsByCountry(String country);

    List<Film> searchFilmsByDirection(String direction);

    List<Film> searchFilmsByGenres(String genres);

    void saveFilm(Film film);

    void deleteFilm(Integer idFilm);

    void updateFilm(Film film);

    void insertActor(Integer idFilm, Integer idActor);

    void removeActor(Integer idFilm, Integer idActor);
}
