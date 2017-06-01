package main.java;

import json.JSONObject;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class Good {

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String subCategory;
    private double price;

    public Good(String good_temp) {
        barcode = new JSONObject(good_temp).getString("barcode");
        name = new JSONObject(good_temp).getString("name");
        unit = new JSONObject(good_temp).getString("unit");
        category = new JSONObject(good_temp).getString("category");
        subCategory = new JSONObject(good_temp).getString("subCategory");
        price = new JSONObject(good_temp).getDouble("price");
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
