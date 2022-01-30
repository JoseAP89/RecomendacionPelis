package com.back.Models;

import org.springframework.lang.Nullable;

public class FormaUsuario {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String alias;
    private String correo;
    private String edad;
    private String genero;
    private String password;
    @Nullable
    private String token;
    private int genero_favorito_id;
    private String genero_favorito_nombre;
    private int actor_favorito_id;
    private String actor_favorito_nombre;
    private int dir_favorito_id;
    private String dir_favorito_nombre;
    private int peli_favorita_id;
    private String peli_favorita_nombre;


    public FormaUsuario(){}


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


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public int getGenero_favorito_id() {
        return genero_favorito_id;
    }


    public void setGenero_favorito_id(int genero_favorito_id) {
        this.genero_favorito_id = genero_favorito_id;
    }


    public String getGenero_favorito_nombre() {
        return genero_favorito_nombre;
    }


    public void setGenero_favorito_nombre(String genero_favorito_nombre) {
        this.genero_favorito_nombre = genero_favorito_nombre;
    }


    public int getActor_favorito_id() {
        return actor_favorito_id;
    }


    public void setActor_favorito_id(int actor_favorito_id) {
        this.actor_favorito_id = actor_favorito_id;
    }


    public String getActor_favorito_nombre() {
        return actor_favorito_nombre;
    }


    public void setActor_favorito_nombre(String actor_favorito_nombre) {
        this.actor_favorito_nombre = actor_favorito_nombre;
    }


    public int getDir_favorito_id() {
        return dir_favorito_id;
    }


    public void setDir_favorito_id(int dir_favorito_id) {
        this.dir_favorito_id = dir_favorito_id;
    }


    public String getDir_favorito_nombre() {
        return dir_favorito_nombre;
    }


    public void setDir_favorito_nombre(String dir_favorito_nombre) {
        this.dir_favorito_nombre = dir_favorito_nombre;
    }


    public int getPeli_favorita_id() {
        return peli_favorita_id;
    }


    public void setPeli_favorita_id(int peli_favorita_id) {
        this.peli_favorita_id = peli_favorita_id;
    }


    public String getPeli_favorita_nombre() {
        return peli_favorita_nombre;
    }


    public void setPeli_favorita_nombre(String peli_favorita_nombre) {
        this.peli_favorita_nombre = peli_favorita_nombre;
    }
    
}