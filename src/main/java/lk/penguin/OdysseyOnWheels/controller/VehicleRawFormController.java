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
import java.util.Set;

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
        txtVehicleNameFx.setEditable(true);
        txtTypeFx.setEditable(true);
        txtPerDayCostFx.setEditable(true);
        txtAccessMileage.setEditable(true);
    }

    public void setData(VehicleDTO dto) {
        lblVehicleIDFx.setText(dto.getVehicleId());
        txtTypeFx.setText(dto.getVehicleType());
        txtVehicleNameFx.setText(dto.getVehicleName());
        txtPerDayCostFx.setText(dto.getPerDay80Km());
        txtAccessMileage.setText(dto.getExcessMileage());

        ObservableList<Integer> statusList= FXCollections.observableArrayList(1,0);
        cmbAvailableFx.setItems(statusList);

        if(statusList.contains(dto.getStatus())){
            cmbAvailableFx.setValue(dto.getStatus());
        }else {
            System.out.println("Not in list");
        }
    }
    @FXML
    void cmbStatusOnAction(ActionEvent event) {
        if(isValidated()){
            System.out.println("elakiri");
        }
    }

    private boolean isValidated() {
        boolean isvehicleTypeValidated= Set.of("luxury","SUV","luxury van","MVP","normal").contains(txtTypeFx.getText());
        if(!isvehicleTypeValidated){
            txtTypeFx.setStyle("-fx-text-fill: red;");
        }

        boolean isName=txtVehicleNameFx.getText().matches("\\w{6,}");
        if (!isName){
            txtVehicleNameFx.setStyle("-fx-text-fill: red;");

        }

        boolean isPerDayCost=!(txtPerDayCostFx.getText()!=null);
        if(!isPerDayCost){
            txtPerDayCostFx.setStyle("-fx-text-fill: red;");
        }
        boolean isExcessMilage=!(txtAccessMileage.getText()!=null);
        if(!isExcessMilage){
            txtAccessMileage.setStyle("-fx-text-fill: red;");
        }
        return isvehicleTypeValidated && isName && isPerDayCost && isExcessMilage;

    }

    public void initialize(){
        txtVehicleNameFx.setEditable(false);
        txtTypeFx.setEditable(false);
        txtPerDayCostFx.setEditable(false);
        txtAccessMileage.setEditable(false);
    }
}
