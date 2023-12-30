package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;

public class CustomerRawFormController {

    @FXML
    private AnchorPane customerrawFxId;

    @FXML
    private Label lblCustEmail;

    @FXML
    private Label lblCustId;

    @FXML
    private Label lblCustName;

    @FXML
    private Label lblCustNic;

    @FXML
    private Label lblCustCountry;

    @FXML
    void btnCustDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnCustUpdateOnAction(ActionEvent event) {

    }

    public void setData(CustomerDTO dto) {
        this.lblCustNic.setText(dto.getCustomerNIC());
        this.lblCustName.setText(dto.getCustomerName());
        this.lblCustCountry.setText(dto.getCustomerCountry());
        this.lblCustEmail.setText(dto.getCustomerEmail());
    }
}
