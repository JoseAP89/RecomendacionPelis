package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneroContainer {
    private List<Genero> genres;

    public List<Genero> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Genero genero : genres) {
            data.append(genero.toString() + ",\n");
        }
        return data.toString();
    }

}
