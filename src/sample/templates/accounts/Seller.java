package sample.templates.accounts;

import sample.SaverReader;
import sample.services.costumers.customersRegistration.CustomerRegistration;
import sample.services.data.Data;
import sample.templates.orders.Product;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class Seller extends Person implements Serializable, Editable {


    private int id;
    private String shopName;
    private ArrayList<Integer> products = new ArrayList<Integer>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }


    public void addNewProduct(String name, String group, String description, int price, int stock, String imagePath) throws IOException {
        int id = Data.products.size();
        int sellerId = this.id;
        Product newProduct = new Product(id, name, group, description, price, sellerId, stock, imagePath);
        Data.products.add(newProduct);
        products.add(id);
        SaverReader.printWriter();
    }

    public String addStock(int productId, int number){
        for (Product product : Data.products){
            if (product.getId() == productId){
                if (product.getStock() - number >= 0) {
                    product.setStock(product.getStock() + number);
                    return product.getName() + " new stock is: " + product.getStock() + " +" + number;
                }
            }
        }
        return "Product not found!";
    }


    public ArrayList<Product> showProduct(String group){

        int sellerId = Data.loggedSeller.getId();
        ArrayList<Product> sellerProducts = new ArrayList<Product>();
        for (Product product : Data.products) {
            if (product.getSellerId() == sellerId) {
                sellerProducts.add(product);
            }
        }

        ArrayList<Product> sortedProducts = new ArrayList<Product>();
        if (!group.equals("All")) {
            for (Product product : sellerProducts) {
                if (product.getGroup().equals(group)) {
                    sortedProducts.add(product);
                }
            }
            return sortedProducts;
        }
        return sellerProducts;
    }


    public boolean login(String email, String password){

        for (Seller seller : Data.sellses) {
            if (seller.getEmail().equals(email) && seller.getPassword().equals(password)) {
                    Data.loggedSeller = seller;
                    return true;
            }
        }
        return false;
    }


    public String editProfile(String name, String familyName, int phoneNumber,
                              String email, String password, String shopName) throws IOException {

        Data.loggedSeller.setName(name);
        Data.loggedSeller.setFamilyName(familyName);
        Data.loggedSeller.setPhoneNumber(phoneNumber);
        String tempEmail = Data.loggedSeller.getEmail();
        for (int i = 0; i < Data.emails.size(); i++) {
            if (Data.emails.get(i).equals(Data.loggedSeller.getEmail())) {
                Data.emails.remove(i);
                break;
            }
        }
        if (!tempEmail.equals(email)) {
            if (CustomerRegistration.checkEmail(email) ) {
                Data.loggedSeller.setEmail(email);
            }
            else {
                return "This email already used!";
            }
        } else {
            Data.loggedSeller.setEmail(tempEmail);
        }
        Data.loggedSeller.setPassword(password);
        Data.loggedSeller.setShopName(shopName);
        return name + ", Your Data Changed Successfully!";
    }
}