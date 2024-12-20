package com.example.buffetlight;

import com.google.gson.annotations.SerializedName;

public class FoodModel {
    @SerializedName("names")
    private String name;      // Название
    @SerializedName("ingredients")
    private String ingredients; // Состав
    @SerializedName("price")
    private String price;     // Цена

    // Конструктор
    public FoodModel(String name, String ingredients, String price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    // Геттер для названия
    public String getName() {
        return name;
    }

    // Сеттер для названия
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для состава
    public String getIngredients() {
        return ingredients;
    }

    // Сеттер для состава
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    // Геттер для цены
    public String getPrice() {
        return price;
    }

    // Сеттер для цены
    public void setPrice(String price) {
        this.price = price;
    }
}