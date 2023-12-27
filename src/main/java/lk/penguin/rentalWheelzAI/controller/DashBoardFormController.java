package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;

public class DashBoardFormController {


    @FXML
    void btnUserSettings(MouseEvent event) {

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "customerManageForm.fxml");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "employeeManageForm.fxml");
    }

    @FXML
    void btnRentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {

    }

}
