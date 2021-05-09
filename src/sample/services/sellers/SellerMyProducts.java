package sample.services.sellers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.SaverReader;
import sample.services.data.Data;
import sample.templates.orders.Product;

public class SellerMyProducts {
    final ObservableList<String> types = FXCollections.observableArrayList("All");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> groupCombo;

    @FXML
    private Button backBtn;

    @FXML
    private Label sellerProducts;

    @FXML
    private Label fillIn;


    @FXML
    private Button showBtn;

    @FXML
    void show(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        fillIn.setText("");
        if (groupCombo.getValue() == null) {
            fillIn.setText("*Please Choose Group of Products");
        } else if (Data.loggedSeller.getProducts().size() == 0) {
            fillIn.setText("*No Products to Show");
        } else {
            List<Product> theList = Data.loggedSeller.showProduct(groupCombo.getValue());
            String theText = "";
            /*System.out.println(Data.loggedSeller.getId());
            System.out.println(Data.products.get(0).getName());
            System.out.println(Data.products.get(0).getSellerId());*/
            for (Product product : theList) {
                theText += product.getName() + " theID: " + product.getId() +
                        " price: " + product.getPrice() + " stock left: " +
                        product.getStock() + " group: " + product.getGroup() + "\n";
            }
            //System.out.println(theList.size());
            sellerProducts.setText(theText);
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
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
        assert sellerProducts != null : "fx:id=\"sellerProducts\" was not injected: check your FXML file 'SellerMyProducts.fxml'.";
        groupCombo.setItems(types);
    }
}
