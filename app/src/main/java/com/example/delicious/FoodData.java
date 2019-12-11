package com.example.delicious;

public class FoodData {
    private String itemName;
    private String itemDescription;
    private String itemIngriedents;
    private String itemImage;
    private String itemTime;

    public FoodData(){

    }

    public FoodData(String itemName, String itemDescription, String itemIngriedents, String itemImage,String itemTime) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemIngriedents = itemIngriedents;
        this.itemImage = itemImage;
        this.itemTime = itemTime;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemIngriedents() {
        return itemIngriedents;
    }

    public String getItemTime() {
        return itemTime;
    }


    public String getItemImage() {
        return itemImage;
    }

}
