package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerSaveFormController {

    @FXML
    private JFXComboBox<?> cmbCustCountry;

    @FXML
    private Label lblCustCountrylabel;

    @FXML
    private Label lblCustNamelabel;

    @FXML
    private Label lblEmaillabel;

    @FXML
    private Label lblNicTitle;

    @FXML
    private TextField txtCustEmail;

    @FXML
    private TextField txtCustINic;

    @FXML
    private TextField txtCustName;

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}
