package com.back.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Recomendacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long recomendacion_id;
    private long api_id;
    private String title;
    private String overview;
    private String poster_path;
    private String release_date;
    private long usuario_id;
    private long catalogo_id;
    private String genre_ids;
    private Date creado;
    private Date modificado;
    
    public void setRecomendacion_id(long r){
        this.recomendacion_id = r;
    }

    public void setApi_id(long a){
        this.api_id = a;
    }

    public void setTitle(String t){
        this.title = t;
    }

    public void setOverview(String o){
        this.overview = o;
    }

    public void setPoster_path(String p){
        this.poster_path = p;
    }

    public void setRelease_date(String r){
        this.release_date = r;
    }

    public void setUsuario_id(long id){
        this.usuario_id = id;
    }

    public void setGenre_ids(String g){
        this.genre_ids = g;
    }
    
    public void setCatalogo_id(Long id){
        this.catalogo_id = id;
    }
    public void setCreado(Date c){
        this.creado = c;
    }

    public void setModificado(Date m){
        this.modificado = m;
    }

    public long getRecomendacion_id( ){
        return this.recomendacion_id;
    }

    public long getApi_id( ){
        return this.api_id;
    }

    public String getTitle( ){
        return this.title;
    }

    public String getOverview( ){
        return this.overview;
    }

    public String getPoster_path( ){
        return this.poster_path;
    }

    public String getRelease_date( ){
        return this.release_date;
    }
    
    public long getUsuario_id( ){
        return this.usuario_id;
    }

    public String getGenre_ids( ){
        return this.genre_ids;
    }

    public long getCatalogo_id( ){
        return this.catalogo_id;
    }
    
    public Date getCreado( ){
        return this.creado;
    }

    public Date getModificado( ){
        return this.modificado;
    }

    @Override
    public String toString() {
        return "Recomendacion [recomendacion_id=" + recomendacion_id + ", catalogo_id=" + catalogo_id +
               ", title=" + title + ", overview=" + overview + "]";
    }

}
