package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LocationRawFormController {

    @FXML
    private JFXButton btnUpdateFxId;

    @FXML
    private JFXComboBox<?> cmbStatusFxId;

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
        ObservableList<String> statusType= FXCollections.observableArrayList( "Available","Unavailable");
        cmbStatusFxId.setItems(statusType);
    }
}
