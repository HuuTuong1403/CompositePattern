package com.example.compositepatternphone;

import java.util.ArrayList;

public class Brands extends CatalogComponent {
    private String brandName;
    private ArrayList<ProductLines> productLines;
    private ArrayList<Phone> phoneList = new ArrayList<>();

    public Brands(String brandName, ArrayList<ProductLines> productLines) {
        this.brandName = brandName;
        this.productLines = productLines;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<ProductLines> getProductLines() {
        return productLines;
    }

    public void setProductLines(ArrayList<ProductLines> productLines) {
        this.productLines = productLines;
    }

    public ArrayList<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public ArrayList<Phone> getItems() {
        for (ProductLines productLine: productLines) {
            ArrayList<Phone> phoneListTemp = productLine.getItems();
            for (Phone phone: phoneListTemp) {
                phoneList.add(phone);
            }
        }
        return phoneList;
    }
}
