package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerRawFormController {

    @FXML
    private AnchorPane customerrawFxId;

    @FXML
    private Label lblCustEmail;



    @FXML
    private Label lblCustName;

    @FXML
    private Label lblCustNic;

    @FXML
    private Label lblCustCountry;

    CustomerBO customerBO=new CustomerBOImpl();

    @FXML
    void btnCustDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        boolean isDeleted=customerBO.deleteCustomer(lblCustNic.getText());
        if(isDeleted){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane,"customerManageForm.fxml");
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Delete uncessful");
        }
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