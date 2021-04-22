package com.example.compositepatternphone;

import java.util.ArrayList;

public class ProductLines extends CatalogComponent{
    private String lineName;
    private ArrayList<Phone> phoneList;

    public ProductLines(String lineName, ArrayList<Phone> phoneList) {
        this.lineName = lineName;
        this.phoneList = phoneList;
    }
    @Override
    public ArrayList<Phone> getItems() {
        return phoneList;
    }
}
