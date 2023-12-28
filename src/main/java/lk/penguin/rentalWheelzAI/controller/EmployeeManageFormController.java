package lk.penguin.rentalWheelzAI.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    }

    private void createEmployeeRawLoadPane(EmployeeDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(EmployeeManageFormController.class.getResource("/view/employeeRawForm.fxml"));
        Parent root=loader.load();
        EmployeeRawFormController controller=loader.getController();

        controller.setData(dto);

        mainContainer.getChildren().add(root);
    }
}
