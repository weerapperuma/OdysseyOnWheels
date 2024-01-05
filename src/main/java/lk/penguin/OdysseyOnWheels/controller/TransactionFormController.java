package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class TransactionFormController {

    @FXML
    private JFXButton RentSaveButtonOnAction;

    @FXML
    private VBox addToCartVboxInterface;

    @FXML
    private Pane placeOrderInterface;

    @FXML
    private Pane tableLoadPaneInterface;

    @FXML
    private AnchorPane transactionLoadingPane;


    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        Navigation.switchPaging(RentalCustomerFormController.getInstance().tableLoadPane, "vehicleTableForm.fxml");
    }
}