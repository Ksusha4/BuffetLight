package com.example.buffetlight.poop;

public class ListItem {
    private String text;
    private int imageResId;
    private String price;
    private String ing;


    public ListItem(String text, int imageResId, String price, String ing) {
        this.text = text;
        this.imageResId = imageResId;
        this.price = price;
        this.ing = ing;
    }

    public String getText() {
        return text;
    }

    public int getImageResId() {
        return imageResId;
    }
    public String getPrice() {
        return price;
    }

    public String getIng() {
        return ing;
    }

}
