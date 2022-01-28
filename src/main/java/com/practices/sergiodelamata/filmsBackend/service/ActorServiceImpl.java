package com.practices.sergiodelamata.filmsBackend.service;

import com.practices.sergiodelamata.filmsBackend.dao.IActorDAO;
import com.practices.sergiodelamata.filmsBackend.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService{
    @Autowired
    IActorDAO actorDAO;

    @Override
    public List<Actor> searchAll() {
        return actorDAO.searchAll();
    }

    @Override
    public Actor searchActorById(Integer idActor) {
        return actorDAO.searchActorById(idActor);
    }

    @Override
    public List<Actor> searchActorsByName(String name) {
        return actorDAO.searchActorsByName(name);
    }

    @Override
    public void saveActor(Actor actor) {
        if(actorDAO.searchActorById(actor.getIdActor()) == null)
        {
            actorDAO.saveActor(actor);
        }
    }

    @Override
    public void deleteActor(Integer idActor) {
        if(actorDAO.searchActorById(idActor) != null ){
            actorDAO.deleteActor(idActor);
        }
    }

    @Override
    public void updateActor(Actor actor) {
        if(actorDAO.searchActorById(actor.getIdActor()) != null){
            actorDAO.updateActor(actor);
        }
    }

    @Override
    public void insertFilm(Integer idActor, Integer idFilm) {
        actorDAO.insertFilm(idActor, idFilm);
    }

    @Override
    public void removeFilm(Integer idActor, Integer idFilm) {
        actorDAO.removeFilm(idActor, idFilm);
    }
}
