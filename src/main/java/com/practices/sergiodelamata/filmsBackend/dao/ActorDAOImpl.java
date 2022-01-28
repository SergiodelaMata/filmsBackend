package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Actor;
import com.practices.sergiodelamata.filmsBackend.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorDAOImpl implements IActorDAO{
    @Autowired
    IActorJPA actorJPA;

    @Autowired
    IFilmJPA filmJPA;

    @Override
    public List<Actor> searchAll(){
        return actorJPA.findAll();
    }

    @Override
    public Actor searchActorById(Integer idActor) {
        Optional<Actor> optional = actorJPA.findById(idActor);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Actor> searchActorsByName(String name) {
        return actorJPA.findByNameContaining(name);
    }

    @Override
    public void saveActor(Actor actor) {
        actorJPA.save(actor);
    }

    @Override
    public void deleteActor(Integer idActor) {
        actorJPA.deleteById(idActor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorJPA.save(actor);
    }

    @Override
    public void insertFilm(Integer idActor, Integer idFilm) {
        Optional<Actor> optionalActor = actorJPA.findById(idActor);
        if(optionalActor.isPresent())
        {
            Actor actor = optionalActor.get();
            System.out.println(actor.getFilms().size());
            Optional<Film> optionalFilm = filmJPA.findById(idFilm);
            if(optionalFilm.isPresent())
            {
                actor.addFilm(optionalFilm.get());
                actorJPA.save(actor);
            }
        }
    }

    @Override
    public void removeFilm(Integer idActor, Integer idFilm){
        Optional<Actor> optionalActor = actorJPA.findById(idActor);
        if(optionalActor.isPresent())
        {
            Actor actor = optionalActor.get();
            Optional<Film> optionalFilm = filmJPA.findById(idFilm);
            if(optionalFilm.isPresent())
            {
                actor.removeFilm(optionalFilm.get());
                actorJPA.save(actor);
            }
        }
    }
}
