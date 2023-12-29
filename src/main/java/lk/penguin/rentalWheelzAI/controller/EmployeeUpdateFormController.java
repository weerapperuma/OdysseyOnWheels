package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.Navigation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeUpdateFormController {
    EmployeeManageFormController employeeManageFormController=new EmployeeManageFormController();
    EmployeeBO employeeBO = new EmployeeBOImpl(employeeManageFormController);

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


    public EmployeeDTO loadIds(){

        this.txtEmpName=txtEmpName;
        this.txtEmpEmail=txtEmpEmail;
        this.txtEmpAddress=txtEmpAddress;
        this.txtEmpINic=txtEmpINic;
        this.txtEmpPosition=txtEmpPosition;
        this.txtEmpContact=txtEmpContact;
        EmployeeDTO dto=new EmployeeDTO();
        dto.setEmployeeId(EmployeeRawFormController.empId);
        dto.setEmployeeName(txtEmpName.getText());
        dto.setEmpEmail(txtEmpEmail.getText());
        dto.setEmpNIC(txtEmpINic.getText());
        dto.setEmpPosition(txtEmpPosition.getText());
        dto.setEmpAddress(txtEmpAddress.getText());
        dto.setEmpContact(txtEmpContact.getText());

        return dto;
    }


    public void initialize() throws SQLException, ClassNotFoundException {
        lblEmpId.setText(EmployeeRawFormController.empId);
        ArrayList<EmployeeDTO> dtos=employeeBO.showAll(EmployeeRawFormController.empId);
        txtEmpName.setText(dtos.getFirst().getEmployeeName());
        txtEmpEmail.setText(dtos.getFirst().getEmpEmail());
        txtEmpINic.setText(dtos.getFirst().getEmpNIC());
        txtEmpPosition.setText(dtos.getFirst().getEmpPosition());
        txtEmpAddress.setText(dtos.getFirst().getEmpAddress());
        txtEmpContact.setText(dtos.getFirst().getEmpContact());
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        EmployeeDTO dto=loadIds();
        boolean isUpdated=employeeBO.update(dto);
        System.out.println(dto.getEmployeeName());
        System.out.println(isUpdated);
        if(isUpdated){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane,"employeeManageForm.fxml");
            Navigation.closePopup();
        }
    }

}
