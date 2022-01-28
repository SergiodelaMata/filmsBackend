package com.practices.sergiodelamata.filmsBackend.controller;

import com.practices.sergiodelamata.filmsBackend.model.Film;
import com.practices.sergiodelamata.filmsBackend.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    IFilmService filmService;

    @GetMapping("/films")
    public List<Film> searchAll(){
        return filmService.searchAll();
    }

    @GetMapping("/films/{idFilm}")
    public Film searchFilmById(@PathVariable("idFilm") Integer idFilm){
        return filmService.searchFilmById(idFilm);
    }

    @GetMapping("/films/title/{title}")
    public List<Film> searchFilmsByTitle(@PathVariable("title") String title){
        return filmService.searchFilmsByTitle(title);
    }

    @GetMapping("/films/year/{yearInit}/{yearEnd}")
    public List<Film> searchFilmsByYear(@PathVariable("yearInit") Integer yearInit, @PathVariable("yearEnd") Integer yearEnd){
        return filmService.searchFilmsByYear(yearInit, yearEnd);
    }

    @GetMapping("/films/country/{country}")
    public List<Film> searchFilmsByCountry(@PathVariable("country") String country){
        return filmService.searchFilmsByCountry(country);
    }

    @GetMapping("/films/direction/{direction}")
    public List<Film> searchFilmsByDirection(@PathVariable("direction") String direction){
        return filmService.searchFilmsByDirection(direction);
    }

    @GetMapping("/films/genres/{genres}")
    public List<Film> searchFilmsByGenres(@PathVariable("genres") String genres){
        return filmService.searchFilmsByGenres(genres);
    }

    @PostMapping("/films")
    public void saveFilm(@RequestBody Film film){
        filmService.saveFilm(film);
    }

    @DeleteMapping("/films/{idFilm}")
    public void deleteFilm(@PathVariable("idFilm") Integer idFilm){
        filmService.deleteFilm(idFilm);
    }

    @PutMapping("/films")
    public void updateFilm(@RequestBody Film film){
        filmService.updateFilm(film);
    }

    @PutMapping("/films/insert/actor/{idFilm}/{idActor}")
    public void insertFilm(@PathVariable("idFilm") Integer idFilm, @PathVariable("idActor") Integer idActor){
        filmService.insertActor(idFilm, idActor);
    }

    @DeleteMapping("/films/delete/actor/{idFilm}/{idActor}")
    public void deleteFilm(@PathVariable("idFilm") Integer idFilm, @PathVariable("idActor") Integer idActor){
        filmService.removeActor(idFilm, idActor);
    }

}
