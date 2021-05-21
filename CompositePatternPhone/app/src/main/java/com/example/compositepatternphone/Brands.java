package com.example.compositepatternphone;

import java.util.ArrayList;

public class Brands extends CatalogComponent {
    private String brandName;
    private ArrayList<ProductLines> productLines;
    private ArrayList<Phone> phoneList = new ArrayList<>();

    public Brands(String brandName, ArrayList<ProductLines> productLines) {
        this.brandName = brandName;
        this.productLines = productLines;
        for (ProductLines productLine: productLines) {
            ArrayList<Phone> phoneListTemp = productLine.getItems();
            for (Phone phone: phoneListTemp) {
                phoneList.add(phone);
            }
        }
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public ArrayList<Phone> getItems() {
        return phoneList;
    }
}
