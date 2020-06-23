package com.example.parcial3_paredes_guerra_terrones_arango_duran.BD;

import java.io.Serializable;

public class Users implements Serializable {
    //String Users = "CREATE TABLE Users(name TEXT, id TEXT, email TEXT, pass TEXT,type TEXT)";

    private String name;
    private String id;
    private String email;
    private String pass;
    private String type;

    public Users(){

    }
    public Users(String name, String id, String email, String pass, String type){
        this.name = name;
        this.id = id;
        this.email =email;
        this.pass =pass;
        this.type =type;

    }

    public String getName(){return name;}
    public void setName(String name){ this.name =name;}

    public String getId(){return id;}
    public void setId (String id){ this.id =id;}

    public String getEmail(){return email;}
    public void setEmail(String email){ this.email =email;}

    public String getPass(){return pass;}
    public void setPass(String pass){ this.pass =pass;}

    public String getType(){return type;}
    public void setType(String type){ this.type =type;}

}
