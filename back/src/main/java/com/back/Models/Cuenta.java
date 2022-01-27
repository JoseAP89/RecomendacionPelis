package com.back.Models;

public class Cuenta {
    private String alias_correo;
    private String password;


    public String getAlias_correo( ){
        return this.alias_correo;
    }

    public void setAlias_correo(String alias_correo){
        this.alias_correo = alias_correo;
    }

    public String getPassword( ){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}

