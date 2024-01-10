package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VehicleRawFormController {

    @FXML
    private JFXComboBox<?> cmbAvailableFx;

    @FXML
    private Label lblVehicleIDFx;

    @FXML
    private TextField txtAccessMileage;

    @FXML
    private TextField txtPerDayCostFx;

    @FXML
    private TextField txtTypeFx;

    @FXML
    private TextField txtVehicleNameFx;

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
