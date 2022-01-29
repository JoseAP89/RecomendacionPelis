package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoRecomendacionContainer {
    private List<Recomendacion> results;

    public List<Recomendacion> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Recomendacion item : results) {
            data.append(item.toString() + ",\n");
        }
        return data.toString();
    }

}
