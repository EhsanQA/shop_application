package sample.services.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.admin.Admin;
import sample.services.admin.RegisterAtWareHouse;
import sample.templates.orders.Order;

public class AdminRegisteringOrders {
    final ObservableList<String> types = FXCollections.observableArrayList("All");
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label theText;

    @FXML
    private Button registerBtn;

    @FXML
    private Label success;

    @FXML
    private Button cancel;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterAtWareHouse.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 1000);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }


    @FXML
    void register(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Admin.admin.registerPurchasesOnWarehouse(Admin.admin.showUnregisteredPurchasesOnWarehouse().
                get(RegisterAtWareHouse.index));
        success.setText("Order Registered Successfully");
        theText.setText("");
    }
    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert theText != null : "fx:id=\"theText\" was not injected: check your FXML file 'AdminRegisteringOrders.fxml'.";
        assert registerBtn != null : "fx:id=\"registerBtn\" was not injected: check your FXML file 'AdminRegisteringOrders.fxml'.";
        assert success != null : "fx:id=\"success\" was not injected: check your FXML file 'AdminRegisteringOrders.fxml'.";
        Order theOrder = Admin.admin.showUnregisteredPurchasesOnWarehouse().get(RegisterAtWareHouse.index);
        String temp = theOrder.getBuyer().getName() + " " + theOrder.getBuyer().getFamilyName() + "\n" + "Phone Number: " +
                theOrder.getBuyer().getPhoneNumber() + "\n" + "Email: " +theOrder.getBuyer().getEmail() +
                "\n" + "Address: " + theOrder.getBuyer().getAddress() + "\n" + "Post Code: " +
                theOrder.getBuyer().getPostCode() + "\n" + "\n";
        for (int i = 0; i < theOrder.getCart().size(); i++) {
            System.out.println("INININ");
            System.out.println("THE NUMBER OF theOrder.getCart() is: " + i);
            temp += theOrder.getCart().get(i).getName()
                    + "  Count: " + theOrder.getStocksCart().get(i) +
                    "  Price: " + theOrder.getCart().get(i).getPrice() + "\n";
        }

        theText.setText(temp);
    }
}
