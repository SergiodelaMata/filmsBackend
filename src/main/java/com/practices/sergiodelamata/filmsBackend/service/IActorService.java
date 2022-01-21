package com.practices.sergiodelamata.filmsBackend.service;

import com.practices.sergiodelamata.filmsBackend.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> searchAll();

    Actor searchActorById(Integer idActor);

    List<Actor> searchActorsByName(String name);

    void saveActor(Actor actor);

    void deleteActor(Integer idActor);

    void updateActor(Actor actor);

    void insertFilm(Integer idActor, Integer idFilm);
}
