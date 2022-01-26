package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneroContainer {
    private List<Box> genres;

    public List<Box> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Box genero : genres) {
            data.append(genero.toString() + ",\n");
        }
        return data.toString();
    }

}
