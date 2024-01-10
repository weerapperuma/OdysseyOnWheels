package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.util.Arrays;
import java.util.List;

public class VehicleRawFormController {

    @FXML
    private JFXComboBox<Integer> cmbAvailableFx;

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

    public void setData(VehicleDTO dto) {
        lblVehicleIDFx.setText(dto.getVehicleId());
        txtTypeFx.setText(dto.getVehicleType());
        txtVehicleNameFx.setText(dto.getVehicleName());
        txtPerDayCostFx.setText(dto.getPerDay80Km());
        txtAccessMileage.setText(dto.getExcessMileage());

        List<Integer> statusValues= Arrays.asList(1,0);
        ObservableList<Integer> statusList= FXCollections.observableList(statusValues);

        if(statusList.contains(dto.getStatus())){
            cmbAvailableFx.setValue(dto.getStatus());
        }else {
            System.out.println("Not in list");
        }
    }
}
