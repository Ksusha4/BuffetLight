package com.example.buffetlight;

public class FoodModel {
    private String name;      // Название
    private String ingredients; // Состав
    private double price;     // Цена

    // Конструктор
    public FoodModel(String name, String ingredients, double price) {
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
    public double getPrice() {
        return price;
    }

    // Сеттер для цены
    public void setPrice(double price) {
        this.price = price;
    }
}