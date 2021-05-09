package sample.services.sellers;

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

public class SellerLandingPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label name;

    @FXML
    private Button editProfileBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button addNewProductBtn;

    @FXML
    private Button myProductsBtn;

    @FXML
    private Button editProductsBtn;

    @FXML
    void addNewProduct(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerAddingProduct.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 490);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void editProducts(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerEditingStock.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerLoginPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void myProducts(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerMyProducts.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void editProfile(ActionEvent event) throws IOException{
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerEditingProfile.fxml"));
        Scene a = new Scene(root, 605, 490);
        Stage b = (Stage)((Node) event.getSource()).getScene().getWindow();
        b.setTitle("Shop");
        b.setScene(a);
        b.setResizable(false);
        b.show();
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SellerLandingPage.fxml'.";
        assert logOutBtn != null : "fx:id=\"logOutBtn\" was not injected: check your FXML file 'SellerLandingPage.fxml'.";
        assert addNewProductBtn != null : "fx:id=\"addNewProductBtn\" was not injected: check your FXML file 'SellerLandingPage.fxml'.";
        assert myProductsBtn != null : "fx:id=\"myProductsBtn\" was not injected: check your FXML file 'SellerLandingPage.fxml'.";
        assert editProductsBtn != null : "fx:id=\"editProductsBtn\" was not injected: check your FXML file 'SellerLandingPage.fxml'.";
        name.setText("Hello " + Data.loggedSeller.getName());
    }
}
