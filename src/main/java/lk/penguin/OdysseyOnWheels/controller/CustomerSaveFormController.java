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
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerSaveFormController {

    @FXML
    private JFXComboBox<String> cmbCustCountry;

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

    CustomerBO customerBO=new CustomerBOImpl();
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList countryList=customerBO.countryList();
        cmbCustCountry.setItems(countryList);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        CustomerDTO customerDTO=new CustomerDTO(txtCustINic.getText(),txtCustName.getText(),cmbCustCountry.getValue(),txtCustEmail.getText());
        boolean isSaved=customerBO.save(customerDTO);
        if(isSaved){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "customerManageForm.fxml");
            Navigation.closePopup();
        }

    }

}
