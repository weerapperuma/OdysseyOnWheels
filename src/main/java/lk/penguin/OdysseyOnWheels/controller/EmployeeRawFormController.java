package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.bo.custom.EmployeeBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.EmployeeBOImpl;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.io.IOException;
import java.sql.SQLException;


public class EmployeeRawFormController {

    @FXML
    private AnchorPane employeerawFxId;

    @FXML
    private Label lblEmpAddress;

    @FXML
    private Label lblEmpContact;

    @FXML
    private Label lblEmpEmail;

    @FXML
    private Label lblEmpId;

    @FXML
    private Label lblEmpName;

    @FXML
    private Label lblEmpNic;

    @FXML
    private Label lblEmpPosition;

    public static String empId;
    EmployeeManageFormController employeeManageFormController;

    EmployeeBO employeeBO=new EmployeeBOImpl(employeeManageFormController);
    @FXML
    void btnEmpDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String empId=lblEmpId.getText();
        SQLUtil.execute("DELETE FROM employee WHERE employeeId=?",empId);
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "employeeManageForm.fxml");

    }

    @FXML
    void btnEmpUpdateOnAction(ActionEvent event) throws IOException {
        String empId2=lblEmpId.getText();
        empId = empId2;
        System.out.println(empId);
        Navigation.popupPaging(BackgroundFormController.getInstance().pagingPane, "employeeUpdateForm.fxml");
    }

    public void setData(EmployeeDTO dto) {
        this.lblEmpId.setText(dto.getEmployeeId());
        this.lblEmpName.setText(dto.getEmployeeName());
        this.lblEmpEmail.setText(dto.getEmpEmail());
        this.lblEmpNic.setText(dto.getEmpNIC());
        this.lblEmpPosition.setText(dto.getEmpPosition());
        this.lblEmpAddress.setText(dto.getEmpAddress());
        this.lblEmpContact.setText(dto.getEmpContact());
    }
}