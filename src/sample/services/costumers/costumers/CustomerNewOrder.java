package sample.services.costumers.costumers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class CustomerNewOrder {
    public static int index = -1;
    final ObservableList<String> types = FXCollections.observableArrayList("All");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn10;

    @FXML
    private Button cancelBtn;

    @FXML
    private ComboBox<String> groupCombo;

    @FXML
    private Label fillIn;

    @FXML
    private Button showBtn;

    @FXML
    void show(ActionEvent event) {
        if (groupCombo.getValue() == null) {
            fillIn.setText("*Please Choose the Group");
        } else {
            List<Button> buttons = new ArrayList<>();
            buttons.add(btn1);
            buttons.add(btn2);
            buttons.add(btn3);
            buttons.add(btn4);
            buttons.add(btn5);
            buttons.add(btn6);
            buttons.add(btn7);
            buttons.add(btn8);
            buttons.add(btn9);
            buttons.add(btn10);
            int productCount = Data.products.size();
            for (int i = 0; i < productCount; i++) {
                buttons.get(i).setText(Data.products.get(i).getName());
                buttons.get(i).setDisable(false);
            }
        }
    }

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
    void btn10(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 9;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn2(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 1;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn3(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 2;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn4(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 3;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn5(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 4;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn6(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 5;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn7(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 6;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn8(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 7;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn9(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 8;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void btn1(ActionEvent event) throws IOException {
        SaverReader.printWriter();
        index = 0;
        Parent root = FXMLLoader.load(getClass().getResource("ProductPage.fxml"));
        Scene adminLoggedInScene = new Scene(root, 605, 400);
        Stage adminLoggedInStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        adminLoggedInStage.setTitle("Shop");
        adminLoggedInStage.setScene(adminLoggedInScene);
        adminLoggedInStage.setResizable(false);
        adminLoggedInStage.show();
    }

    @FXML
    void initialize() throws IOException {
        groupCombo.setItems(types);
        SaverReader.printWriter();
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'CustomerNewOrder.fxml'.";

    }
}
