package sample.services.admin;

import sample.SaverReader;
import sample.services.data.Data;
import sample.templates.accounts.Person;
import sample.templates.accounts.Seller;
import sample.services.costumers.customersRegistration.CustomerRegistration;
import sample.templates.orders.Order;
import sample.templates.orders.Product;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


class Admin extends Person implements Serializable {


    public static Admin admin;


    public static boolean login(String email, String password) {

        if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


    String registerSeller(String name, String familyName, int phoneNumber, String email, String password, String shopName) throws IOException {
        SaverReader.printWriter();
        Seller newSeller = new Seller();
        newSeller.setId(Data.sellses.size());
        newSeller.setName(name);
        newSeller.setFamilyName(familyName);
        newSeller.setPhoneNumber(phoneNumber);
        if (CustomerRegistration.checkEmail(email)) {
            newSeller.setEmail(email);
        }
        else {
            return "This email already used!";
        }
        newSeller.setPassword(password);
        newSeller.setShopName(shopName);
        newSeller.setId(Data.sellses.size());
        Data.sellses.add(newSeller);
        return shopName + " registered successfully!";
    }


    ArrayList<Order> showUnregisteredPurchasesOnWarehouse() {
        ArrayList<Order> unregisteredPurchasesOnWarehouse = new ArrayList<Order>();
        for (Order purchase : Data.purchases) {
            if (!purchase.isWarehouseRegistered()){
                unregisteredPurchasesOnWarehouse.add(purchase);
            }
        }
        return unregisteredPurchasesOnWarehouse;
    }


    String registerPurchasesOnWarehouse(Order unregisteredPurchaseOnWarehouse) {
        unregisteredPurchaseOnWarehouse.setWarehouseRegistered(true);
        return "Registered successfully!";
    }
}
