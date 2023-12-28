package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.SQLUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @FXML
    void btnEmpDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String empId=lblEmpId.getText();
        SQLUtil.execute("DELETE FROM employee WHERE employeeId=?",empId);
    }

    @FXML
    void btnEmpUpdateOnAction(ActionEvent event) {

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
