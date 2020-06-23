package com.example.parcial3_paredes_guerra_terrones_arango_duran.BD;

import java.io.Serializable;

public class Recipes implements Serializable {
    //String Users = CREATE TABLE Recipes(name TEXT, description TEXT, ingredients TEXT,restaurant TEXT, comments TEXT);

    private String name;
    private String description;
    private String ingredients;
    private String restaurant;
    private String comments;

    public Recipes(){

    }
    public Recipes(String name, String description, String ingredients, String restaurant, String comments){
        this.name = name;
        this.description = description;
        this.ingredients =ingredients;
        this.restaurant =restaurant;
        this.comments =comments;

    }

    public String getName(){return name;}
    public void setName(String name){ this.name =name;}

    public String getDescription(){return description;}
    public void setDescription (String description){ this.description =description;}

    public String getIngredients(){return ingredients;}
    public void setIngredients(String ingredients){ this.ingredients =ingredients;}

    public String getRestaurant(){return restaurant;}
    public void setRestaurant(String restaurant){ this.restaurant =restaurant;}

    public String getComments(){return comments;}
    public void setComments(String comments){ this.comments =comments;}

}