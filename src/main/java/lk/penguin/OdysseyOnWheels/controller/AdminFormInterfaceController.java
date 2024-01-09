package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;

public class AdminFormInterfaceController {

    @FXML
    private Pane adminUseCasesLoadPane;

    @FXML
    private Label lblDateTimeSet;
    private static AdminFormInterfaceController adminFormInterfaceController;
    public AdminFormInterfaceController(){
        adminFormInterfaceController=this;
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "customerManageForm.fxml");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnRentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnVehicleOnAction(ActionEvent event) {

    }

    @FXML
    void closeAppOnAction(ActionEvent event) {

    }

}
