package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CountriesDTO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
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
    CustomerBOImpl customerBO=new CustomerBOImpl();
    CustomerDTO customerDTO=new CustomerDTO();

    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList countryList=customerBO.countryList();
        customerDTO=customerBO.get(CustomerRawFormController.custId);
        System.out.println("Email:"+customerDTO.getCustomerEmail());
        lblCustId.setText(CustomerRawFormController.custId);
        txtCustINic.setText(customerDTO.getCustomerNIC());
        txtCustName.setText(customerDTO.getCustomerName());

        cmbCustCountry.setItems(countryList);
        if (countryList.contains(customerDTO.getCustomerCountry())) {
            cmbCustCountry.setValue(customerDTO.getCustomerCountry());
        }
        txtCustEmail.setText(customerDTO.getCustomerEmail());




    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        CustomerDTO customerDTO1=new CustomerDTO(txtCustINic.getText(),txtCustName.getText(),cmbCustCountry.getValue(),txtCustEmail.getText());
        boolean isUpdated=customerBO.updateCustomer(customerDTO1);
        if(isUpdated){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "customerManageForm.fxml");
            Navigation.closePopup();
        }
    }

}
