package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoContainer {
    private List<Box> results;

    public List<Box> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Box persona : results) {
            data.append(persona.toString() + ",\n");
        }
        return data.toString();
    }

}
