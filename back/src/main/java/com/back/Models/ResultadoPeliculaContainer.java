package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoPeliculaContainer {
    private List<Pelicula> results;

    public List<Pelicula> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Pelicula item : results) {
            data.append(item.toString() + ",\n");
        }
        return data.toString();
    }

}
