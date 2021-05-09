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
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.templates.accounts.Seller;

public class SellerLoginPage {
    static int index;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button backBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Label fillIn;

    @FXML
    void LogIn(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        if (username.getText().isBlank() || password.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else if (Seller.login(username.getText(), password.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("SellerLandingPage.fxml"));
            Scene adminLoggedInScene = new Scene(root, 605, 400);
            Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            adminLoggedInStage.setTitle("Admin Page");
            adminLoggedInStage.setScene(adminLoggedInScene);
            adminLoggedInStage.setResizable(false);
            adminLoggedInStage.show();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setContentText("Incorrect Username or Password");
            alert2.show();
        }
    }


    @FXML
    void goBack(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("../../landingPage.fxml"));
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
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'AdminLoginPage.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'AdminLoginPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'AdminLoginPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'AdminLoginPage.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'AdminLoginPage.fxml'.";
    }
}
