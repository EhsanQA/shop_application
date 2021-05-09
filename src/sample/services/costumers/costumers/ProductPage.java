package sample.services.costumers.costumers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.data.Data;

public class ProductPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label productName;

    @FXML
    private Label description;

    @FXML
    private Label price;

    @FXML
    private Label fillIn;

    @FXML
    private TextField number;

    @FXML
    private Button addToCartBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    void addToCart(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        fillIn.setText("");
        if (number.getText().isBlank()) {
            fillIn.setText("*Please Enter a Number");
        } else {
            fillIn.setText(Data.loggedCustomer.addToCart(Data.products.get(CustomerNewOrder.index),
                    Integer.parseInt(number.getText())));

        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerNewOrder.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 1000);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(true);
        adminLoggedInStage.show();
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert productName != null : "fx:id=\"productName\" was not injected: check your FXML file 'ProductPage.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'ProductPage.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'ProductPage.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'ProductPage.fxml'.";
        assert addToCartBtn != null : "fx:id=\"addToCartBtn\" was not injected: check your FXML file 'ProductPage.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'ProductPage.fxml'.";
        productName.setText(Data.products.get(CustomerNewOrder.index).getName());
        description.setText(Data.products.get(CustomerNewOrder.index).getDescription());
        price.setText("price: $" + Data.products.get(CustomerNewOrder.index).getPrice());
    }
}
