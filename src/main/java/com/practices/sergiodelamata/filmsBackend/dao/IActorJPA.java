package com.practices.sergiodelamata.filmsBackend.dao;

import com.practices.sergiodelamata.filmsBackend.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorJPA extends JpaRepository<Actor, Integer> {
    List<Actor> findByNameContaining(String name);
}