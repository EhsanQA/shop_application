package sample.templates.orders;

import sample.templates.orders.Image;
import java.io.IOException;
import java.io.Serializable;


public class Product implements Serializable {


    private int id;
    private String name;
    private String group;
    private String description;
    private int price;
    private int sellerId;
    private int stock;
    private String imagePath;


    public Product(){}

    public Product(int id, String name, String group, String description, int price, int sellerId, int stock, String imagePath) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;
        this.stock = stock;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
