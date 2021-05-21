package com.example.compositepatternphone;

public class Phone {
    private String name;
    private String description;
    private int Image;
    private String Price;

    public Phone(String name, String description, int image, String price) {
        this.name = name;
        this.description = description;
        Image = image;
        Price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public int getImage() {
        return Image;
    }
    public String getPrice() {
        return Price;
    }
}
