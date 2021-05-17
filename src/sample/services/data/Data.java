package sample.services.data;

import sample.templates.accounts.Customer;
import sample.templates.accounts.Seller;
import sample.templates.orders.Order;
import sample.templates.orders.Product;
import java.util.ArrayList;


public class Data {

    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Seller> sellses = new ArrayList<Seller>();
    public static ArrayList<String> emails = new ArrayList<String>();
    public static ArrayList<Product> products = new ArrayList<Product>();
    public static ArrayList<Order> purchases = new ArrayList<Order>();

    public static Seller loggedSeller = new Seller();
    public static Customer loggedCustomer = new Customer();
}