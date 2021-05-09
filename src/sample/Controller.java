package sample;

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
import javafx.stage.Stage;
import sample.services.admin.AdminInitializer;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminBtn;

    @FXML
    private Button customerBtn;

    @FXML
    private Button sellerBtn;

    @FXML
    void admin(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("services/admin/AdminLoginPage.fxml"));
        Scene logOutScene = new Scene(root, 605, 400);
        Stage logOutStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        logOutStage.setTitle("Login");
        logOutStage.setScene(logOutScene);
        logOutStage.setResizable(false);
        logOutStage.show();
    }

    @FXML
    void customer(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("services/costumers/costumers/CustomerLoginPage.fxml"));
        Scene logOutScene = new Scene(root, 605, 400);
        Stage logOutStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        logOutStage.setTitle("Login");
        logOutStage.setScene(logOutScene);
        logOutStage.setResizable(false);
        logOutStage.show();
    }

    @FXML
    void seller(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        Parent root = FXMLLoader.load(getClass().getResource("services/sellers/SellerLoginPage.fxml"));
        Scene logOutScene = new Scene(root, 605, 400);
        Stage logOutStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        logOutStage.setTitle("Login");
        logOutStage.setScene(logOutScene);
        logOutStage.setResizable(false);
        logOutStage.show();
    }

    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        assert adminBtn != null : "fx:id=\"adminBtn\" was not injected: check your FXML file 'landingPage.fxml'.";
        assert customerBtn != null : "fx:id=\"customerBtn\" was not injected: check your FXML file 'landingPage.fxml'.";
        assert sellerBtn != null : "fx:id=\"sellerBtn\" was not injected: check your FXML file 'landingPage.fxml'.";
        if (temp.temps()) {
            initializer();
            SaverReader.reader();
            SaverReader.printWriter();
        }
    }
    void initializer() throws IOException, ClassNotFoundException {
        AdminInitializer.initializer();
    }
}
