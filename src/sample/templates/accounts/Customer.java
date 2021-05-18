package sample.templates.accounts;

import sample.services.costumers.customersRegistration.CustomerRegistration;
import sample.services.data.Data;
import sample.templates.orders.Order;
import sample.templates.orders.Product;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class Customer extends Person implements Serializable {


    private int postCode;
    private String address;
    public Order currentOrder;
    private ArrayList<Order> purchaseHistory = new ArrayList<Order>();


    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addPurchaseHistory(Order order) {
        this.purchaseHistory.add(order);
    }


    public boolean login(String email, String password){

        for (Customer customer : Data.customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                Data.loggedCustomer = customer;
                return true;
            }
        }
        return false;
    }


    public String addToCart(Product product, int stock){

        if (stock < 0){
            return "Please enter positive number!";
        }

        if (currentOrder != null){
            if (product.getStock() - stock >= 0) {
                currentOrder.addProductToCart(product);
                currentOrder.addStocksCart(stock);
                product.setStock(product.getStock() - stock);
                return "Product added successfully!";
            }
        }
        else {
            currentOrder = new Order();
            currentOrder.setBuyer(Data.loggedCustomer);
            currentOrder.setOrderId(Data.purchases.size());
            if (product.getStock() - stock >= 0) {
                currentOrder.addProductToCart(product);
                currentOrder.addStocksCart(stock);
                product.setStock(product.getStock() - stock);
                return "Product added successfully!";
            }
        }
        return "We have no enough stock! Product stock is: " + product.getStock();
    }


    public ArrayList<Product> showProduct(String group){

        ArrayList<Product> sortedProducts = new ArrayList<Product>();
        if (!group.equals("All")) {
            for (Product product : Data.products) {
                if (product.getGroup().equals(group)) {
                    sortedProducts.add(product);
                }
            }
            return sortedProducts;
        }
        return Data.products;
    }


    public Order showCart(){
        return currentOrder;
    }


    public String purchase(){
        purchaseHistory.add(currentOrder);
        Data.purchases.add(currentOrder);
        currentOrder = null;
        return "The purchase was successfully registered!";
    }


    public String editProfile(String name, String familyName, int phoneNumber,
                       String email, String password, int postCode, String address) throws IOException {

        Data.loggedCustomer.setName(name);
        Data.loggedCustomer.setFamilyName(familyName);
        Data.loggedCustomer.setPhoneNumber(phoneNumber);
        String tempEmail = Data.loggedCustomer.getEmail();
        for (int i = 0; i < Data.emails.size(); i++) {
            if (Data.emails.get(i).equals(Data.loggedCustomer.getEmail())) {
                Data.emails.remove(i);
                break;
            }
        }
        if (!tempEmail.equals(email)) {
            if (CustomerRegistration.checkEmail(email) ) {
                Data.loggedCustomer.setEmail(email);
            }
            else {
                return "This email already used!";
            }
        } else {
            Data.loggedCustomer.setEmail(tempEmail);
        }
        Data.loggedCustomer.setPassword(password);
        Data.loggedCustomer.setPostCode(postCode);
        Data.loggedCustomer.setAddress(address);
        return name + ", Your Data Changed Successfully!";
    }
}