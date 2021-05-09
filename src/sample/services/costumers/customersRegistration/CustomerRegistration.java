package sample.services.costumers.customersRegistration;


import sample.SaverReader;
import sample.services.data.Data;
import sample.templates.accounts.Customer;

import java.io.IOException;


public class CustomerRegistration {


    static String registerCustomer(String name, String familyName, int phoneNumber, String email, String password, int postCode, String address) throws IOException {
        SaverReader.printWriter();
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setFamilyName(familyName);
        newCustomer.setPhoneNumber(phoneNumber);
        if (CustomerRegistration.checkEmail(email)) {
            newCustomer.setEmail(email);
        }
        else {
            return "This email already used!";
        }
        newCustomer.setPassword(password);
        newCustomer.setPostCode(postCode);
        newCustomer.setAddress(address);
        Data.customers.add(newCustomer);
        SaverReader.printWriter();
        return name + ", you are registered successfully!";
    }


    public static boolean checkEmail(String email) throws IOException {
        SaverReader.printWriter();
        for (String element : Data.emails) {
            if (element.contains(email)) {
                return false;
            }
        }
        Data.emails.add(email);
        return true;
    }
}
