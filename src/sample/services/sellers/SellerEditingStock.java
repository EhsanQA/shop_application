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

public class SellerEditingStock {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id;

    @FXML
    private TextField addingStockNumber;

    @FXML
    private Label fillIn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label success;

    @FXML
    private Button addBtn;

    @FXML
    void add(ActionEvent event) throws IOException {
        if (id.getText().isBlank() || addingStockNumber.getText().isBlank()) {
            fillIn.setText("*Please Fill in the Fields");
        } else if (!Data.loggedSeller.getProducts().contains(Integer.parseInt(id.getText()))) {
            fillIn.setText("*the ID isn't Your Product");
        } else {
            fillIn.setText(Data.loggedSeller.addStock(Integer.parseInt(id.getText()),
                    Integer.parseInt(addingStockNumber.getText())));
            cancelBtn.setText("Done");
            id.setText("");
            addingStockNumber.setText("");
        }
        SaverReader.printWriter();
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("SellerLandingPage.fxml"));
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
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'SellerEditingStock.fxml'.";
        assert addingStockNumber != null : "fx:id=\"addingStockNumber\" was not injected: check your FXML file 'SellerEditingStock.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'SellerEditingStock.fxml'.";
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'SellerEditingStock.fxml'.";

    }
}
