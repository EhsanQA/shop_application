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

public class CustomerCartPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button purchaseBtn;

    @FXML
    private Label total;

    @FXML
    private Button backBtn;

    @FXML
    private Label theText;

    @FXML
    private Label fillIn;

    @FXML
    void back(ActionEvent event) throws IOException {
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
    void purchase(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        fillIn.setText("");
        if (Data.loggedCustomer.currentOrder == null) {
            fillIn.setText("*You Don't Have Anything to Purchase");
        } else {
            fillIn.setText(Data.loggedCustomer.purchase());
            theText.setText("");
            total.setText("");
        }
    }

    @FXML
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert purchaseBtn != null : "fx:id=\"purchaseBtn\" was not injected: check your FXML file 'CustomerCartPage.fxml'.";
        assert total != null : "fx:id=\"total\" was not injected: check your FXML file 'CustomerCartPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'CustomerCartPage.fxml'.";
        assert theText != null : "fx:id=\"theText\" was not injected: check your FXML file 'CustomerCartPage.fxml'.";
        assert fillIn != null : "fx:id=\"fillIn\" was not injected: check your FXML file 'CustomerCartPage.fxml'.";
        if (Data.loggedCustomer.currentOrder != null) {
            if (Data.loggedCustomer.currentOrder.getStocksCart().size() == 0) {
                theText.setText("");
                total.setText("");
            } else {
                String temp = "";
                int theTotal = 0;
                for (int i = 0; i < Data.loggedCustomer.currentOrder.getStocksCart().size(); i++) {
                    temp += Data.loggedCustomer.currentOrder.getCart().get(i).getName() + "  number:  " +
                            Data.loggedCustomer.currentOrder.getStocksCart().get(i) + "\n";
                    theTotal += Data.loggedCustomer.currentOrder.getStocksCart().get(i) *
                            Data.loggedCustomer.currentOrder.getCart().get(i).getPrice();
                }
                theText.setText(temp);
                total.setText("Total Payment: $" + String.valueOf(theTotal));
            }
        }

    }
}
