package com.back.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Favorito {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long favorito_id;
    private long api_id;
    private long usuario_id;
    private String nombre_completo;
    private long catalogo_id;
    private Date creado;
    private Date modificado;

    public long getFavorito_id() {
        return favorito_id;
    }

    public long getApi_id() {
        return api_id;
    }

    public void setApi_id(long api_id) {
        this.api_id = api_id;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public long getCatalogo_id() {
        return catalogo_id;
    }

    public void setCatalogo_id(long catalogo_id) {
        this.catalogo_id = catalogo_id;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }


    @Override
    public String toString() {
        return "Favorito [api_id=" + api_id + ", catalogo_id=" + catalogo_id + ", favorito_id=" + favorito_id
                + ", nombre_completo=" + nombre_completo + ", usuario_id=" + usuario_id + "]";
    }

}
