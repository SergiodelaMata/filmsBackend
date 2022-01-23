package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFilmJPA extends JpaRepository<Film, Integer> {
    List<Film> findByTitleContaining(String title);

    List<Film> findByYearBetween(Integer yearInit, Integer yearEnd);

    List<Film> findByCountryLike(String country);

    List<Film> findByDirectionContaining(String direction);

    List<Film> findByGenresContaining(String genres);
}