package com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades;

public class Fav_Recipes {
    private int id_user;
    private int id_recipes;

    public Fav_Recipes( int idu, int idr){

        id_user= idu;
        id_recipes=idr;

    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_recipes() {
        return id_recipes;
    }

    public void setId_recipes(int id_recipes) {
        this.id_recipes = id_recipes;
    }
}

