package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

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
    void btnUpdateOnAction(ActionEvent event) {

    }

}
