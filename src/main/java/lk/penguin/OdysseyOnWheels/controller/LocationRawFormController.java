package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.LocationsBO;
import lk.penguin.OdysseyOnWheels.dto.LocationsDTO;

import java.sql.SQLException;

public class LocationRawFormController {

    @FXML
    private JFXButton btnUpdateFxId;

    @FXML
    private JFXComboBox<String> cmbStatusFxId;

    @FXML
    private TextField txtLocationFx;
    LocationsBO locationsBO=(LocationsBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.LOCATIONS);

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        txtLocationFx.setEditable(true);
        cmbStatusFxId.setEditable(true);

    }

    @FXML
    void cmbStatusOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isUpdated=locationsBO.update(new LocationsDTO(nb,txtLocationFx.getText(),cmbStatusFxId.getValue()));
        if(isUpdated){
            txtLocationFx.setStyle("-fx-text-fill: #00ff12;");
            cmbStatusFxId.setStyle("-fx-text-fill: #00ff12;");
        }
        txtLocationFx.setEditable(false);
        cmbStatusFxId.setEditable(false);
    }

    @FXML
    void txtLocationOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isUpdated=locationsBO.update(new LocationsDTO(nb,txtLocationFx.getText(),cmbStatusFxId.getValue()));
        if(isUpdated){
            txtLocationFx.setStyle("-fx-text-fill: #00ff12;");
            cmbStatusFxId.setStyle("-fx-text-fill: #00ff12;");
        }
        txtLocationFx.setEditable(false);
        cmbStatusFxId.setEditable(false);
    }
    int nb=0;

    public void initialize(){
        txtLocationFx.setEditable(false);
        cmbStatusFxId.setEditable(false);
    }

    public void setData(LocationsDTO locationsDTO) {
        ObservableList<String> statusType= FXCollections.observableArrayList( "Available","Unavailable");
        cmbStatusFxId.setItems(statusType);
        txtLocationFx.setText(locationsDTO.getYardName());
        nb=locationsDTO.getNb();
        if(statusType.contains(locationsDTO.getStatus())){
            cmbStatusFxId.setValue(locationsDTO.getStatus());
        }
        else {
            System.out.println("DTO status not in combo box");
        }
    }
}
