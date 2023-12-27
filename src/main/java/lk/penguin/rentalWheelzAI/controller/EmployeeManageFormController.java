package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dao.impl.EmployeeDAOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeManageFormController {
    @FXML
    private VBox mainContainer;

    @FXML
    private Label employeeAddressFxId;

    @FXML
    private Label employeeContactFxId;

    @FXML
    private Label employeeEmailFxId;

    @FXML
    private Label employeeNameFxId;

    @FXML
    private Label employeeNicFxId;

    @FXML
    private Label employeePositionFxId;

    @FXML
    private Pane employeeRawLoadPane;

    @FXML
    private Label employeeidFxId;
    EmployeeDAOImpl employeeDAO=new EmployeeDAOImpl();

    @FXML
    void employeeDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void employeeUpdateOnAction(ActionEvent event) {

    }

    public void initialize() throws SQLException, ClassNotFoundException {

        ResultSet rst= SQLUtil.execute("SELECT * FROM employee");
        ArrayList<EmployeeDTO>dtos=new ArrayList<>();
        while (rst.next()){
            EmployeeDTO dto=new EmployeeDTO();

            dto.setEmployeeId(rst.getString("employeeId"));
            dto.setEmployeeName(rst.getString("employeeName"));
            dto.setEmpEmail(rst.getString("empEmail"));
            dto.setEmpNIC(rst.getString("empNIC"));
            dto.setEmpPosition(rst.getString("empPosition"));
            dto.setEmpAddress(rst.getString("empAddress"));
            dto.setEmpContact(rst.getString("empContact"));

            dtos.add(dto);

        }
        if (!dtos.isEmpty()){
            employeeidFxId.setText(dtos.get(0).getEmployeeId());
            employeeNameFxId.setText(dtos.get(0).getEmployeeName());
            employeeEmailFxId.setText(dtos.get(0).getEmpEmail());
            employeeNicFxId.setText(dtos.get(0).getEmpNIC());
            employeePositionFxId.setText(dtos.get(0).getEmpPosition());
            employeeAddressFxId.setText(dtos.get(0).getEmpAddress());
            employeeContactFxId.setText(dtos.get(0).getEmpContact());

        }

    }
}
