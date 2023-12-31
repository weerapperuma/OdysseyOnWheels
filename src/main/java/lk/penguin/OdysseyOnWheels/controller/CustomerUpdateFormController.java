package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;

import java.sql.SQLException;

public class CustomerUpdateFormController{

    @FXML
    private JFXComboBox<?> cmbCustCountry;

    @FXML
    private Label lblCustCountry;

    @FXML
    private Label lblCustName;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblEmpId;

    @FXML
    private Label lblNic;

    @FXML
    private TextField txtCustEmail;

    @FXML
    private TextField txtCustINic;

    @FXML
    private TextField txtCustName;

    CustomerBO customerBO=new CustomerBOImpl();
    CustomerDTO customerDTO=new CustomerDTO();

    public void initialize(){

    }
    @FXML
    boolean btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        return customerBO.updateCustomer(customerDTO);
    }

}
