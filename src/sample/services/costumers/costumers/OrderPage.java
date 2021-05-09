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

public class OrderPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label theText;

    @FXML
    private Label fillIn;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
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
    void initialize() throws IOException {
        SaverReader.printWriter();
        assert theText != null : "fx:id=\"theText\" was not injected: check your FXML file 'OrderPage.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'OrderPage.fxml'.";
        if (Data.loggedCustomer.getPurchaseHistory().size() == 0) {
            fillIn.setText("*Nothing to Show");
        } else {
            String temp = "";
            for (int i = 0; i < Data.loggedCustomer.getPurchaseHistory().get(CustomerPurchaseHistory.index).getCart().size()
                    ; i++) {
                temp += Data.loggedCustomer.getPurchaseHistory().get(CustomerPurchaseHistory.index).getCart().get(i).getName()
                        + "  Count: " + Data.loggedCustomer.getPurchaseHistory().get(CustomerPurchaseHistory.index).
                        getStocksCart().get(i) + "  Price: " + Data.loggedCustomer.
                        getPurchaseHistory().get(CustomerPurchaseHistory.index).getCart().get(i).getPrice() + "\n";
            }

            theText.setText(temp);

        }
    }
}
