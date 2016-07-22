package com.example.fabian.springapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by fabian on 22-05-16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nombres {

    private int id ;
    private String name ;
    private String email;
    private String created_at;
    private String  updated_at;

    public String getId(){
     String numero="";

        numero = String.valueOf(id);
        numero=Integer.toString(id);
        return numero;
    }
    public String getName(){

        return this.name;
    }
    public String getEmail(){

        return this.email;
    }
    public String getCreated_at(){

        return this.created_at;
    }
    public String getUpdated_at(){

        return this.updated_at;
    }




}
