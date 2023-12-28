package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dao.impl.EmployeeDAOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeManageFormController {
    @FXML
    private VBox mainContainer;
    @FXML
    private Pane managePane;
    @FXML
    private ScrollPane scrolePane;

    public void initialize() throws SQLException, ClassNotFoundException, IOException {

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
        for(EmployeeDTO dto:dtos){
            createEmployeeRawLoadPane(dto);
        }
//        if (!dtos.isEmpty()){
//            employeeidFxId.setText(dtos.get(0).getEmployeeId());
//            employeeNameFxId.setText(dtos.get(0).getEmployeeName());
//            employeeEmailFxId.setText(dtos.get(0).getEmpEmail());
//            employeeNicFxId.setText(dtos.get(0).getEmpNIC());
//            employeePositionFxId.setText(dtos.get(0).getEmpPosition());
//            employeeAddressFxId.setText(dtos.get(0).getEmpAddress());
//            employeeContactFxId.setText(dtos.get(0).getEmpContact());
//
//        }
    }

    private void createEmployeeRawLoadPane(EmployeeDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(EmployeeManageFormController.class.getResource("/view/employeeRawForm.fxml"));
        Parent root=loader.load();
        EmployeeRawFormController controller=loader.getController();

        controller.setData(dto);
//        controller.employeeNameFxId.setText(dto.getEmployeeName());
//        controller.employeeEmailFxId.setText(dto.getEmpEmail());
//        controller.employeeNicFxId.setText(dto.getEmpNIC());
//        controller.employeePositionFxId.setText(dto.getEmpPosition());
//        controller.employeeAddressFxId.setText(dto.getEmpAddress());
//        controller.employeeContactFxId.setText(dto.getEmpContact());

        mainContainer.getChildren().add(root);
    }
}
