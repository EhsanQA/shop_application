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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.admin.Admin;

public class AdminAddingSeller {

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
    private TextField theID;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Label fillIn;

    @FXML
    private TextField email;

    @FXML
    private Label success;


    @FXML
    private TextField password;

    @FXML
    private TextField shopName;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("AdminLandingPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        if (firstName.getText().isBlank() || lastName.getText().isBlank() ||
        phoneNumber.getText().isBlank() || email.getText().isBlank() ||
        password.getText().isBlank() ||shopName.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else {
            success.setText(Admin.admin.registerSeller(firstName.getText(), lastName.getText(), Integer.parseInt(phoneNumber.getText()),
                    email.getText(), password.getText(), shopName.getText()));
            firstName.setText("");
            lastName.setText("");
            phoneNumber.setText("");
            email.setText("");
            password.setText("");
            shopName.setText("");
            cancelBtn.setText("Done");
        }
        SaverReader.printWriter();
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert theID != null : "fx:id=\"theID\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert nextBtn != null : "fx:id=\"nextBtn\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
        assert shopName != null : "fx:id=\"shopName\" was not injected: check your FXML file 'AdminAddingSeller.fxml'.";
    }
}
