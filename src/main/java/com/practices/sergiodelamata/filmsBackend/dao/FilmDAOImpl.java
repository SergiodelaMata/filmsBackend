package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmDAOImpl implements IFilmDAO{
    @Autowired
    IFilmJPA filmJPA;

    @Override
    public List<Film> searchAll() {
        return filmJPA.findAll();
    }

    @Override
    public Film searchFilmById(Integer idFilm) {
        Optional<Film> optional = filmJPA.findById(idFilm);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Film> searchFilmsByTitle(String title) {
        return filmJPA.findByTitleContaining(title);
    }

    @Override
    public List<Film> searchFilmsByYear(Integer yearInit, Integer yearEnd) {
        return filmJPA.findByYearBetween(yearInit, yearEnd);
    }

    @Override
    public List<Film> searchFilmsByCountry(String country) {
        return filmJPA.findByCountryLike(country);
    }

    @Override
    public List<Film> searchFilmsByDirection(String direction) {
        return filmJPA.findByDirectionContaining(direction);
    }

    @Override
    public List<Film> searchFilmsByGenres(String genres) {
        return filmJPA.findByGenresContaining(genres);
    }

    @Override
    public void saveFilm(Film film) {
        filmJPA.save(film);
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        filmJPA.deleteById(idFilm);
    }

    @Override
    public void updateFilm(Film film) {
        filmJPA.save(film);
    }
}
