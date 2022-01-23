package com.practices.sergiodelamata.filmsBackend.service;

import com.practices.sergiodelamata.filmsBackend.dao.IFilmDAO;
import com.practices.sergiodelamata.filmsBackend.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements IFilmService{
    @Autowired
    IFilmDAO filmDAO;

    @Override
    public List<Film> searchAll() {
        return filmDAO.searchAll();
    }

    @Override
    public Film searchFilmById(Integer idFilm) {
        return filmDAO.searchFilmById(idFilm);
    }

    @Override
    public List<Film> searchFilmsByTitle(String title) {
        return filmDAO.searchFilmsByTitle(title);
    }

    @Override
    public List<Film> searchFilmsByYear(Integer yearInit, Integer yearEnd) {
        return filmDAO.searchFilmsByYear(yearInit, yearEnd);
    }

    @Override
    public List<Film> searchFilmsByCountry(String country) {
        return filmDAO.searchFilmsByCountry(country);
    }

    @Override
    public List<Film> searchFilmsByDirection(String direction) {
        return filmDAO.searchFilmsByDirection(direction);
    }

    @Override
    public List<Film> searchFilmsByGenres(String genres) {
        return filmDAO.searchFilmsByGenres(genres);
    }

    @Override
    public void saveFilm(Film film) {
        if(filmDAO.searchFilmById(film.getIdFilm()) == null)
        {
            filmDAO.saveFilm(film);
        }
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        if(filmDAO.searchFilmById(idFilm) != null)
        {
            filmDAO.deleteFilm(idFilm);
        }
    }

    @Override
    public void updateFilm(Film film) {
        if(filmDAO.searchFilmById(film.getIdFilm()) != null)
        {
            filmDAO.updateFilm(film);
        }
    }
}
