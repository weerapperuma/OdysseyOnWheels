package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

public class VehcileTransactionTableRawController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label lblExcessMilageCost;

    @FXML
    private Label lblPerDayCost;

    @FXML
    private Label lblVehiId;

    @FXML
    private Label lblVehiName;

    @FXML
    private Label lblVehiType;

    @FXML
    private AnchorPane vehickeTransaxtionRaw;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    public void setData(VehicleDTO dto) {
        lblVehiId.setText(dto.getVehicleId());
        lblVehiType.setText(dto.getVehicleType());
        lblVehiName.setText(dto.getVehicleName());
        lblPerDayCost.setText(dto.getPerDay80Km());
        lblExcessMilageCost.setText(dto.getExcessMileage());
    }
}
