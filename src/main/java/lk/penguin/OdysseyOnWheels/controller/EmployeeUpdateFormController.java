package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeUpdateFormController {
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);

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
    private JFXButton btnEmpIdFxId;
    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Navigation.closePopup();
    }


    public void initialize() throws SQLException, ClassNotFoundException {
        EmployeeDTO employeeDTO=employeeBO.get(EmployeeRawFormController.empId);
        btnEmpIdFxId.setText(employeeDTO.getEmployeeId());
        txtEmpName.setText(employeeDTO.getEmployeeName());
        txtEmpEmail.setText(employeeDTO.getEmpEmail());
        txtEmpINic.setText(employeeDTO.getEmpNIC());
        txtEmpPosition.setText(employeeDTO.getEmpPosition());
        txtEmpAddress.setText(employeeDTO.getEmpAddress());
        txtEmpContact.setText(employeeDTO.getEmpContact());
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(isValidated()){
            boolean isUpdated=employeeBO.update(new EmployeeDTO(
                    EmployeeRawFormController.empId,
                    txtEmpName.getText(),
                    txtEmpEmail.getText(),
                    txtEmpINic.getText(),
                    txtEmpPosition.getText(),
                    txtEmpAddress.getText(),
                    txtEmpContact.getText()
            ));
            if(isUpdated){
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
