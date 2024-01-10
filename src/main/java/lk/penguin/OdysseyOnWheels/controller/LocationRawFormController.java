package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.dto.LocationsDTO;

public class LocationRawFormController {

    @FXML
    private JFXButton btnUpdateFxId;

    @FXML
    private JFXComboBox<String> cmbStatusFxId;

    @FXML
    private TextField txtLocationFx;

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbStatusOnAction(ActionEvent event) {

    }

    @FXML
    void txtLocationOnAction(ActionEvent event) {

    }

    public void initialize(){

        //cmbStatusFxId.setValue();
    }

    public void setData(LocationsDTO locationsDTO) {
        ObservableList<String> statusType= FXCollections.observableArrayList( "Available","Unavailable");
        cmbStatusFxId.setItems(statusType);
        txtLocationFx.setText(locationsDTO.getYardName());
        System.out.println(locationsDTO.getStatus());
        if(statusType.contains(locationsDTO.getStatus())){
            cmbStatusFxId.setValue(locationsDTO.getStatus());
        }
        else {
            System.out.println("DTO status not in combo box");
        }
    }
}
