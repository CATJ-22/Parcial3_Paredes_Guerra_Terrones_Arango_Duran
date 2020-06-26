package com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades;

public class Fav_Recipes {
    private String name;
    private int id_recipes;
    private String like_recipe;
    private String dislike_recipe;

    public Fav_Recipes(String n , int idr,String lr, String dr){
        name=n;
        id_recipes=idr;
        like_recipe=lr;
        dislike_recipe=dr;

    }

    public String getName() {
        return name;
    }

    public int getId_recipes() {
        return id_recipes;
    }

    public String getLike_recipe() {
        return like_recipe;
    }

    public String getDislike_recipe() {
        return dislike_recipe;
    }
}

