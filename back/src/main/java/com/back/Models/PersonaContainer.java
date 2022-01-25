package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaContainer {
    private List<Dupla> results;

    public List<Dupla> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Dupla persona : results) {
            data.append(persona.toString() + ",\n");
        }
        return data.toString();
    }

}
