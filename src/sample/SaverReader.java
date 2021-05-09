package sample;

import sample.services.data.Data;
import sample.templates.accounts.Customer;
import sample.templates.accounts.Seller;
import sample.templates.orders.Order;
import sample.templates.orders.Product;

import java.io.*;
import java.util.ArrayList;

public class SaverReader {
    public static void printWriter() throws IOException {
        FileOutputStream customersFos = new FileOutputStream("Customers.ser");
        ObjectOutputStream customersOos = new ObjectOutputStream(customersFos);
        customersOos.writeObject(Data.customers);
        customersOos.close();
        customersFos.close();
        FileOutputStream sellsesFos = new FileOutputStream("Sellers.ser");
        ObjectOutputStream sellsesOos = new ObjectOutputStream(sellsesFos);
        sellsesOos.writeObject(Data.sellses);
        sellsesOos.close();
        sellsesFos.close();
        FileOutputStream emailFos = new FileOutputStream("Emails.ser");
        ObjectOutputStream emailOos = new ObjectOutputStream(emailFos);
        emailOos.writeObject(Data.emails);
        emailOos.close();
        emailFos.close();
        FileOutputStream productsFos = new FileOutputStream("Products.ser");
        ObjectOutputStream productsOos = new ObjectOutputStream(productsFos);
        productsOos.writeObject(Data.products);
        productsOos.close();
        productsFos.close();
        FileOutputStream purchasesFos = new FileOutputStream("Purchases.ser");
        ObjectOutputStream purchasesOos = new ObjectOutputStream(purchasesFos);
        purchasesOos.writeObject(Data.purchases);
        purchasesOos.close();
        purchasesFos.close();
    }
    public static void reader() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Customers.ser");
        ObjectInputStream theCustomers = new ObjectInputStream(fis);
        Data.customers = (ArrayList<Customer>) theCustomers.readObject();
        theCustomers.close();
        fis.close();
        FileInputStream fis2 = new FileInputStream("Sellers.ser");
        ObjectInputStream theSellers = new ObjectInputStream(fis2);
        Data.sellses = (ArrayList<Seller>) theSellers.readObject();
        theSellers.close();
        fis2.close();
        FileInputStream fis3 = new FileInputStream("Emails.ser");
        ObjectInputStream theCustomers2 = new ObjectInputStream(fis3);
        Data.emails = (ArrayList<String>) theCustomers2.readObject();
        theCustomers2.close();
        fis3.close();
        FileInputStream fis4 = new FileInputStream("Products.ser");
        ObjectInputStream theCustomers3 = new ObjectInputStream(fis4);
        Data.products = (ArrayList<Product>) theCustomers3.readObject();
        theCustomers3.close();
        fis4.close();
        FileInputStream fis5 = new FileInputStream("Purchases.ser");
        ObjectInputStream theCustomers4 = new ObjectInputStream(fis5);
        Data.purchases = (ArrayList<Order>) theCustomers4.readObject();
        theCustomers4.close();
        fis5.close();
    }
    /*public static void updater(long time) {
        for (Customers i : Controller.users) {
            if (i.getAccountType() == 1) {
                i.setBalance((long) (i.getBalance() +
                        (i.getBalance() * time * 0.001)));
            } else if (i.getAccountType() == 2) {
                i.setBalance((long) (i.getBalance() +
                        (i.getBalance() * time * 0.002)));
            }
        }
    }*/
}
