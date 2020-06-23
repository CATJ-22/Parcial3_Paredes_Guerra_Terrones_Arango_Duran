package com.example.parcial3_paredes_guerra_terrones_arango_duran;

public class Utilidades {
    //Constantes campos tabla users
    public static final String TABLA_USERS = "user";
    public static final String CAMPO_NAME = "name";
    public static final String CAMPO_ID= "id";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASS = "password";
    public static final String CAMPO_TYPE = "type";

    public static final String CREAR_TABLA_USERS = "CREATE TABLE Users(name TEXT, id TEXT, email TEXT, pass TEXT,type TEXT)";

    // Constantes table recipes
    public static final String TABLA_RECIPES = "recipes";
    public static final String CAMPO_Name = "name";
    public static final String CAMPO_Description= "description";
    public static final String CAMPO_Ingredients = "ingredients";
    public static final String CAMPO_Restaurant= "restaurant";
    public static final String CAMPO_Comments = "comments";

    public static final String CREAR_TABLA_RECIPES = "CREATE TABLE Recipes(name TEXT, description TEXT, ingredients TEXT,restaurant TEXT, comments TEXT)";

}



