package com.example.parcial3_paredes_guerra_terrones_arango_duran.Entidades;


public class Recipes{

    private String name;
    private int id_recipes;
    private String description;
    private String ingredients;
    private String restaurant;
    private String comments;
    private String image;

    public Recipes(String n,int ir, String descrip, String ing, String res, String comm, String img){
        name=n;
        id_recipes=ir;
        description=descrip;
        ingredients=ing;
        restaurant=res;
        comments=comm;
        image=img;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_recipes() {
        return id_recipes;
    }

    public void setId_recipes(int id_recipes) {
        this.id_recipes = id_recipes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
