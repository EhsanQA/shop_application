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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.data.Data;


public class SellerAddingProduct {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField group;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Label fillIn;

    @FXML
    private TextField price;

    @FXML
    private Label success;

    @FXML
    private TextField stock;

    @FXML
    private TextArea description;

    @FXML
    void cancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SellerLandingPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        SaverReader.printWriter();
        adminLoggedInStage.show();
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        if (name.getText().isBlank() || group.getText().isBlank() || description.getText().isBlank() ||
         price.getText().isBlank() || stock.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else {
            Data.loggedSeller.addNewProduct(name.getText(), group.getText(), description.getText(),
                    Integer.parseInt(price.getText()), Integer.parseInt(stock.getText()), "");
            success.setText(name.getText() + " Added Successfully");
            cancelBtn.setText("Done");
            name.setText("");
            group.setText("");
            description.setText("");
            price.setText("");
            stock.setText("");
        }
        SaverReader.printWriter();
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert group != null : "fx:id=\"group\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert nextBtn != null : "fx:id=\"nextBtn\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert stock != null : "fx:id=\"stock\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
        assert description != null : "fx:id=\"description\" was not injected: check your FXML file 'SellerAddingProduct.fxml'.";
    }
}
