package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IFilmJPA extends JpaRepository<Film, Integer> {
    List<Film> findByTitleContaining(String title);

    List<Film> findByYearBetween(Date dateInit, Date dateEnd);

    List<Film> findByCountryLike(String country);

    List<Film> findByDirectionContaining(String direction);

    List<Film> findByGenresLike(String genres);
}