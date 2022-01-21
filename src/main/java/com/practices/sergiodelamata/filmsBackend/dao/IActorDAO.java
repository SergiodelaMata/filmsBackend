package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Actor;

import java.util.List;

public interface IActorDAO {
    List<Actor> searchAll();

    Actor searchActorById(Integer idActor);

    List<Actor> searchActorsByName(String name);

    void saveActor(Actor actor);

    void deleteActor(Integer idActor);

    void updateActor(Actor actor);

    void insertFilm(Integer idActor, Integer idFilm);
}
