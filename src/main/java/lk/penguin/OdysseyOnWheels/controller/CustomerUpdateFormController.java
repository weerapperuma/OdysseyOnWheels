package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerUpdateFormController{

    @FXML
    private JFXComboBox<String> cmbCustCountry;

    @FXML
    private Label lblCustCountrylabel;

    @FXML
    private Label lblCustId;

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

    CustomerBO customerBO=new CustomerBOImpl();
    CustomerDTO customerDTO=new CustomerDTO();

    public void initialize() throws SQLException, ClassNotFoundException {
        customerDTO=customerBO.get(CustomerRawFormController.custId);
        lblCustId.setText(CustomerRawFormController.custId);
        txtCustINic.setText(customerDTO.getCustomerNIC());
        txtCustName.setText(customerDTO.getCustomerName());
        txtCustEmail.setText(customerDTO.getCustomerEmail());

        ObservableList countryList=CustomerBOImpl.countryList();
        cmbCustCountry.setItems(countryList);
        if (countryList.contains(customerDTO.getCustomerCountry())) {
            cmbCustCountry.setValue(customerDTO.getCustomerCountry());
        }

    }
    @FXML
    boolean btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO1=new CustomerDTO(txtCustINic.getText(),txtCustName.getText(),cmbCustCountry.getValue(),txtCustEmail.getText());
        return customerBO.updateCustomer(customerDTO1);
    }

}
