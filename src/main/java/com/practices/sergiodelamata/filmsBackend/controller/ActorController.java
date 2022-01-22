package com.practices.sergiodelamata.filmsBackend.controller;

import com.practices.sergiodelamata.filmsBackend.model.Actor;
import com.practices.sergiodelamata.filmsBackend.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    IActorService actorService;

    @GetMapping("/actors")
    public List<Actor> searchAll(){
        return actorService.searchAll();
    }

    @GetMapping("/actors/{idActor}")
    public Actor searchActorById(@PathVariable("idActor") Integer idActor) {
        return actorService.searchActorById(idActor);
    }

    @GetMapping("/actors/name/{name}")
    public List<Actor> searchActorsByName(@PathVariable("name") String name){
        return actorService.searchActorsByName(name);
    }

    @PostMapping("/actors")
    public void saveActor(@RequestBody Actor actor){
        actorService.saveActor(actor);
    }

    @DeleteMapping("/actors")
    public void deleteActor(@PathVariable("idActor") Integer idActor){
        actorService.deleteActor(idActor);
    }

    @PutMapping("/actors")
    public void updateActor(@RequestBody Actor actor){
        actorService.updateActor(actor);
    }
}
