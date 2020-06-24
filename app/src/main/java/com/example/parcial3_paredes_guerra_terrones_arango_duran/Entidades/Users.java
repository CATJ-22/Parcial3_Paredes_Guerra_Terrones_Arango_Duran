package com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades;



public class Users{


    private String name;
    private int id_user;
    private String email;
    private String pass;
    private String type;


    public Users(String n, int i, String e, String p, String t){
       name= n;
       id_user= i;
       email= e;
       pass= p;
       type=t;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id_user;
    }

    public void setId(int id) {
        this.id_user = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
