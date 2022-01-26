package com.back.Models;

public class FormaUsuario {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String alias;
    private String correo;
    private String edad;
    private String genero;
    private String password;
    private String genero_favorito;
    private String actor_favorito;
    private String dir_favorito;
    private String peli_favorito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero_favorito() {
        return genero_favorito;
    }

    public void setGenero_favorito(String genero_favorito) {
        this.genero_favorito = genero_favorito;
    }

    public String getActor_favorito() {
        return actor_favorito;
    }

    public void setActor_favorito(String actor_favorito) {
        this.actor_favorito = actor_favorito;
    }

    public String getDir_favorito() {
        return dir_favorito;
    }

    public void setDir_favorito(String dir_favorito) {
        this.dir_favorito = dir_favorito;
    }

    public String getPeli_favorito() {
        return peli_favorito;
    }

    public void setPeli_favorito(String peli_favorito) {
        this.peli_favorito = peli_favorito;
    }


    public FormaUsuario(){}
    
}