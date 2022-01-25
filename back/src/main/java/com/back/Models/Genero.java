package com.back.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Genero {

    private Long id;
    private String name;

    public Genero() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Genero [id=" + id + ", name=" + name + "]";
    }

}
