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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.data.Data;

public class SellerEditingProfile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Label fillIn;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField shopName;

    @FXML
    private Label success;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerLandingPage.fxml"));
        Scene logOutScene = new Scene(root, 605, 400);
        Stage logOutStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        logOutStage.setTitle("Login");
        logOutStage.setScene(logOutScene);
        logOutStage.setResizable(false);
        logOutStage.show();
    }


    @FXML
    void next(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        if (firstName.getText().isBlank() || lastName.getText().isBlank() ||
                phoneNumber.getText().isBlank() || email.getText().isBlank() || password.getText().isBlank() ||
                shopName.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else {
            success.setText(Data.loggedSeller.editProfile(firstName.getText(), lastName.getText(),
                    Integer.parseInt(phoneNumber.getText()), email.getText(), password.getText(),
                    shopName.getText()));
            cancelBtn.setText("Done");
        }
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert nextBtn != null : "fx:id=\"nextBtn\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert shopName != null : "fx:id=\"shopName\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        assert success != null : "fx:id=\"success\" was not injected: check your FXML file 'SellerEditingProfile.fxml'.";
        firstName.setText(Data.loggedSeller.getName());
        lastName.setText(Data.loggedSeller.getFamilyName());
        phoneNumber.setText(String.valueOf(Data.loggedSeller.getPhoneNumber()));
        email.setText(Data.loggedSeller.getEmail());
        password.setText(Data.loggedSeller.getPassword());
        shopName.setText(Data.loggedSeller.getShopName());
    }
}
