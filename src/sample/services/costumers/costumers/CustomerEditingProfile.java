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

public class CustomerEditingProfile {

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
    private TextField postCode;

    @FXML
    private Label success;

    @FXML
    private TextField address;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("CustomerLandingPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        if (firstName.getText().isBlank() || lastName.getText().isBlank() ||
                phoneNumber.getText().isBlank() || email.getText().isBlank() || password.getText().isBlank() ||
                postCode.getText().isBlank() || address.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else {
            success.setText(Data.loggedCustomer.editProfile(firstName.getText(), lastName.getText(),
                    Integer.parseInt(phoneNumber.getText()), email.getText(), password.getText(),
                    Integer.parseInt(postCode.getText()), address.getText()));
            cancelBtn.setText("Done");
        }


    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert phoneNumber != null : "fx:id=\"phoneNumber\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert nextBtn != null : "fx:id=\"nextBtn\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert postCode != null : "fx:id=\"postCode\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert success != null : "fx:id=\"success\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'CustomerEditingProfile.fxml'.";
        firstName.setText(Data.loggedCustomer.getName());
        lastName.setText(Data.loggedCustomer.getFamilyName());
        phoneNumber.setText(String.valueOf(Data.loggedCustomer.getPhoneNumber()));
        email.setText(Data.loggedCustomer.getEmail());
        password.setText(Data.loggedCustomer.getPassword());
        postCode.setText(String.valueOf(Data.loggedCustomer.getPostCode()));
        address.setText(Data.loggedCustomer.getAddress());
    }
}
