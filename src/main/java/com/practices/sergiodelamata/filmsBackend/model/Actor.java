package com.practices.sergiodelamata.filmsBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor", nullable = false)
    private Integer idActor;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Lob
    @Column(name = "countryBirth", nullable = false)
    private String countryBirth;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "participate", joinColumns = {
            @JoinColumn(name="idActor", referencedColumnName = "idActor")},
            inverseJoinColumns = {@JoinColumn(name="idFilm", referencedColumnName = "idFilm")})
    @JsonIgnoreProperties("actors")
    private List<Film> films = new ArrayList<>();

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idActor);
    }

    public void addFilm(Film film){
        if(film != null){
            getFilms().add(film);
        }
    }

    public void removeFilm(Film film){
        if(film != null){
            getFilms().remove(film);
        }
    }
}