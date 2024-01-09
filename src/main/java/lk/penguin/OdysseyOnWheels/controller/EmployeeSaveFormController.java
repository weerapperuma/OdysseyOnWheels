package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.EmployeeBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.EmployeeBOImpl;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;
import lk.penguin.OdysseyOnWheels.util.REGEXUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class EmployeeSaveFormController {
    EmployeeBO employeeBO=(EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);

    @FXML
    private Label lblEmpId;

    @FXML
    private TextField txtEmpAddress;

    @FXML
    private TextField txtEmpContact;

    @FXML
    private TextField txtEmpEmail;

    @FXML
    private TextField txtEmpINic;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtEmpPosition;
    @FXML
    private Label lblErrorShow;
    String empID="";
    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopup();
    }


    public void initialize() throws SQLException, ClassNotFoundException {
        empID=employeeBO.generateNewId();
        this.lblEmpId.setText(empID);

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(isValidated()){
            boolean isSaved=employeeBO.save(new EmployeeDTO(
                    empID,txtEmpName.getText(),txtEmpEmail.getText(),txtEmpINic.getText(),txtEmpPosition.getText(),txtEmpAddress.getText(),txtEmpContact.getText()
            ));
            if(isSaved){
                Navigation.switchPaging(AdminFormInterfaceController.getInstance().adminUseCasesLoadPane, "employeeManageForm.fxml");
                Navigation.closePopup();
            }
        }
    }

    private boolean isValidated() {
        boolean isEmpNameValidated = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)?$").matcher(txtEmpName.getText()).matches();
        if (!isEmpNameValidated) {
            txtEmpEmail.setStyle("-fx-text-fill: red;");
            return false;
        }
        boolean isEmpEmailValidated= REGEXUtil.validateEmail(txtEmpEmail.getText());
        if(!isEmpEmailValidated){
            txtEmpEmail.setStyle("-fx-text-fill: red;");
            return false;
        }
        if(txtEmpINic.getLength()<5){
            return false;
        }
        boolean isEmpPositionValidated=Pattern.compile("^[A-z]{1,}$").matcher(txtEmpPosition.getText()).matches();
        if(!isEmpPositionValidated){
            new Alert(Alert.AlertType.ERROR,"Invalid Employee Position").show();
            return false;
        }

        boolean isAddressValidated=REGEXUtil.validateAddress(txtEmpAddress.getText());
        if(!isAddressValidated){
            txtEmpAddress.setStyle("-fx-text-fill: red;");
            return false;
        }

        boolean isEmpContactValidated=REGEXUtil.validateContact(txtEmpContact.getText());
        if(!isEmpContactValidated){
            txtEmpContact.setStyle("-fx-text-fill: red;");
            return false;
        }

        return true;
    }

}
