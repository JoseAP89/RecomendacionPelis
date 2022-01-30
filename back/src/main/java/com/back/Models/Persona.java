package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {
    private String id;
    private String name;
    private List<Pelicula> known_for;

    public Persona() {

    }

    public String getName() {
        return name;
    }
    public String getId() {
        return this.id;
    }
    public List<Pelicula> getKnown_for( ){
        return this.known_for;
    }

    public void setKnown_for(List<Pelicula> s){
        this.known_for = s;
    }

    public void setName(String t) {
        this.name = t;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Dupla [id=" + id + ", name=" + name + "]";
    }
}
