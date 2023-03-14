package com.example.cartMS;

public class Item {
    public Item() {
    }

    private long id;
    private String catagory;
    private String name;
    private double price;

    public Item(long id, String catagory, String name, double price) {
        this.id = id;
        this.catagory = catagory;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
