package com.practices.sergiodelamata.filmsBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate birthDate;

    @Lob
    @Column(name = "countryBirth", nullable = false)
    private String countryBirth;

    @ManyToMany
    /*@JoinTable(name = "participate",
            joinColumns = @JoinColumn(name = "idActor"),
            inverseJoinColumns = @JoinColumn(name = "idFilm"))
    Esto no funciona, se ha cambiado a lo siguiente:
    */
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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