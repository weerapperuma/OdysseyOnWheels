package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.custom.TransactionBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.TransactionBOImpl;
import lk.penguin.OdysseyOnWheels.util.Navigation;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

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
    TransactionBO transactionBO=new TransactionBOImpl();

    public static VBox addCart;

    @FXML
    void addToCartSaveRentOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean allDone=transactionBO.saveRentDetails();
        if(allDone){
            addToCartVboxInterface.getChildren().clear();
        }
    }


    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        Navigation.switchPaging(tableLoadPaneInterface, "vehicleTableForm.fxml");
        addCart=addToCartVboxInterface;
    }
}