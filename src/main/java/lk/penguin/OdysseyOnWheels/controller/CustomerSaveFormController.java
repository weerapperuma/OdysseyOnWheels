package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
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

    CustomerBO customerBO=(CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.CUSTOMER);
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<String> countryList=customerBO.countryList();
        cmbCustCountry.setItems(countryList);
        for(String country:countryList){
            cmbCustCountry.setValue(countryList.get(1));
        }
    }

    @FXML
    void closeButtonOnAction(ActionEvent event) {
        Navigation.closePopup();
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        CustomerDTO customerDTO=new CustomerDTO(txtCustINic.getText(),
                txtCustName.getText(),
                cmbCustCountry.getValue(),
                txtCustEmail.getText());
        if(customerBO.save(customerDTO)){
            Navigation.switchPaging(AdminFormInterfaceController.getInstance().adminUseCasesLoadPane, "customerManageForm.fxml");
            Navigation.closePopup();
        }

    }

}
