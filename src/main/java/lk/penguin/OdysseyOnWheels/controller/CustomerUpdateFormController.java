//  public void initialize() throws SQLException, ClassNotFoundException {
//        ObservableList<String> countryList=customerBO.countryList();
//        customerDTO=customerBO.get(CustomerRawFormController.custId);
//        lblCustId.setText(CustomerRawFormController.custId);
//        txtCustINic.setText(customerDTO.getCustomerNIC());
//        txtCustName.setText(customerDTO.getCustomerName());
//
//        cmbCustCountry.setItems(countryList);
//        for(String country:countryList){
//            cmbCustCountry.setValue(countryList.get(1));
//        }
//        txtCustEmail.setText(customerDTO.getCustomerEmail());
//
//    }
//    @FXML
//    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
//        CustomerDTO customerDTO1=new CustomerDTO(txtCustINic.getText(),txtCustName.getText(),cmbCustCountry.getValue(),txtCustEmail.getText());
//        boolean isUpdated=customerBO.updateCustomer(customerDTO1);
//        if(isUpdated){
//            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "customerManageForm.fxml");
//            Navigation.closePopup();
//        }
//    }
//
//}
package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.Navigation;
import lk.penguin.OdysseyOnWheels.util.REGEXUtil;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerUpdateFormController {

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
    @FXML
    private Label lblShowError;
    @FXML
    private JFXButton btnSaveFxId;

    CustomerBO customerBO=(CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.CUSTOMER);
    public void initialize() throws SQLException, ClassNotFoundException {
        txtCustINic.setText(CustomerRawFormController.custId);
        txtCustINic.setEditable(false);
        ObservableList<String> countryList=customerBO.countryList();
        cmbCustCountry.setItems(countryList);
        for(String country:countryList){
            cmbCustCountry.setValue(countryList.get(1));
        }
        CustomerDTO customerDTO=customerBO.get(CustomerRawFormController.custId);
        txtCustName.setText(customerDTO.getCustomerName());
        cmbCustCountry.setValue(customerDTO.getCustomerCountry());
        cmbCustCountry.setOnAction(event ->btnSaveFxId.fire());
    }

    @FXML
    void closeButtonOnAction(ActionEvent event) {
        Navigation.closePopup();
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(isValidated()){
            CustomerDTO customerDTO=new CustomerDTO(txtCustINic.getText(),
                    txtCustName.getText(),
                    cmbCustCountry.getValue(),
                    txtCustEmail.getText());
            if(customerBO.save(customerDTO)){
                Navigation.switchPaging(AdminFormInterfaceController.getInstance().adminUseCasesLoadPane, "customerManageForm.fxml");
                Navigation.closePopup();
            }
        }
        else {
            lblShowError.setText("Invalid Input");
        }


    }

    private boolean isValidated() {
        if(txtCustINic.getLength()!=0){
            System.out.println("passed customer nic");
            if(cmbCustCountry.getValue()!=null){
                System.out.println("passed customer country");
                if(REGEXUtil.validateEmail(txtCustEmail.getText())){
                    System.out.println("email ok");
                    return true;
                }
            }
        }
        if(txtCustINic.getLength()==0){
            lblNicTitle.setStyle("-fx-text-fill: red;");
        }
        if(cmbCustCountry.getValue()==null){
            lblCustCountrylabel.setStyle("-fx-text-fill: red;");
        }
        if(!REGEXUtil.validateEmail(txtCustEmail.getText())){
            lblEmaillabel.setStyle("-fx-text-fill: red;");
        }
        return false;
    }
}
