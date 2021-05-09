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
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.data.Data;

public class CustomerLandingPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button editProfileBtn;

    @FXML
    private Button purchaseHistoryBtn;

    @FXML
    private Button newOrderBtn;

    @FXML
    private Button cartBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Label helloCustomer;

    @FXML
    void cart(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerCartPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void editProfile(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerEditingProfile.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 490);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void newOrder(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerNewOrder.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 10000);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(true);
        adminLoggedInStage.show();
    }

    @FXML
    void purchaseHistory(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerPurchaseHistory.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 10000);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(true);
        adminLoggedInStage.show();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerLoginPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void initialize() throws IOException {
        helloCustomer.setText("Hello " + Data.loggedCustomer.getName());
        SaverReader.printWriter();
        assert editProfileBtn != null : "fx:id=\"editProfileBtn\" was not injected: check your FXML file 'CustomerLandingPage.fxml'.";
        assert purchaseHistoryBtn != null : "fx:id=\"purchaseHistoryBtn\" was not injected: check your FXML file 'CustomerLandingPage.fxml'.";
        assert newOrderBtn != null : "fx:id=\"newOrderBtn\" was not injected: check your FXML file 'CustomerLandingPage.fxml'.";
        assert cartBtn != null : "fx:id=\"cartBtn\" was not injected: check your FXML file 'CustomerLandingPage.fxml'.";
        assert helloCustomer != null : "fx:id=\"helloCustomer\" was not injected: check your FXML file 'CustomerLandingPage.fxml'.";

    }
}
