package com.back.Models;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recomendacion {

    private String id;
    private String title;
    private String overview;
    private String poster_path;
    private String release_date;
    private List<String> genre_ids;

    public Recomendacion() {
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getId() {
        return this.id;
    }

    public String getPoster_path( ){
        return this.poster_path;
    }

    public String getRelease_date( ){
        return this.release_date;
    }
    public List<String> getGenre_ids( ){
        return this.genre_ids;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public void setOverview(String o) {
        this.overview = o;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPoster_path(String p){
        this.poster_path = p;
    }

    public void setRelease_date(String r){
        this.release_date = r;
    }
    public void setGenre_ids(List<String> g ){
        this.genre_ids = g;
    }

    @Override
    public String toString() {
        return "Dupla [id=" + id + ", title=" + title + "]";
    }
}
