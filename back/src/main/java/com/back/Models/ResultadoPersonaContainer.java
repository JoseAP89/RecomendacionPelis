package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoPersonaContainer {
    private List<Persona> results;

    public List<Persona> getResults() {
        return results;
    }


    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Persona persona : results) {
            data.append(persona.toString() + ",\n");
        }
        return data.toString();
    }

}