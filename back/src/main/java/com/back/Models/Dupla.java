package com.back.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dupla {

    private Long id;
    private String name;

    public Dupla() {
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
