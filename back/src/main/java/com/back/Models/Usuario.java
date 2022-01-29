package com.back.Models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity // This tells Hibernate to make a table out of this class
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long usuario_id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String alias;
    private int edad;
    private String genero;
    private String correo;
    private String password;
    private String token;
    private Date creado;
    @Nullable
    private Date modificado;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id= usuario_id;
    }


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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
        return "Usuario [alias=" + alias + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", creado="
                + creado + ", email=" + correo + ", nombre=" + nombre + ", password=" + password + ", usuario_id="
                + usuario_id + "]";
    }
  
}
