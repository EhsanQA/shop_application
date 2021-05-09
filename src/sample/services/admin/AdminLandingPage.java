package sample.services.admin;

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

public class AdminLandingPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label name;

    @FXML
    private Button registerAtWareHouseBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button addAccountBtn;

    @FXML
    void addAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminAddingSeller.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 490);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();

    }


    @FXML
    void registerAtWareHouse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterAtWareHouse.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 1000);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }


    @FXML
    void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLoginPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'AdminLandingPage.fxml'.";
        assert logOutBtn != null : "fx:id=\"logOutBtn\" was not injected: check your FXML file 'AdminLandingPage.fxml'.";
        assert addAccountBtn != null : "fx:id=\"addAccountBtn\" was not injected: check your FXML file 'AdminLandingPage.fxml'.";
    }
}
