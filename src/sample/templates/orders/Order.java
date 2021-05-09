package sample.templates.orders;

import sample.templates.accounts.Customer;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Order implements Serializable {


    private Customer buyer;
    private int orderId;
    private boolean warehouseRegistered = false;
    private ArrayList<Product> productsCart = new ArrayList<Product>();
    private ArrayList<Integer> stocksCart = new ArrayList<Integer>();


    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isWarehouseRegistered() {
        return warehouseRegistered;
    }

    public void setWarehouseRegistered(boolean warehouseRegistered) {
        this.warehouseRegistered = warehouseRegistered;
    }

    public ArrayList<Product> getCart() {
        return productsCart;
    }

    public void addProductToCart(Product product) {
        this.productsCart.add(product);
    }

    public ArrayList<Integer> getStocksCart() {
        return stocksCart;
    }

    public void addStocksCart(int stock) {
        this.stocksCart.add(stock);
    }


    private int total(){
        int total = 0;
        for (int i = 0; i < productsCart.size(); i++) {
            total += productsCart.get(i).getPrice() * stocksCart.get(i);
        }
        return total;
    }
}