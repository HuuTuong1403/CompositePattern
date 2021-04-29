package com.example.compositepatternphone;

public class Phone  {
    private String name;
    private String description;
    private int Image;
    private String Price;
    private String Brand;
    private String ProductLine;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getProductLine() {
        return ProductLine;
    }

    public void setProductLine(String productLine) {
        ProductLine = productLine;
    }
}
