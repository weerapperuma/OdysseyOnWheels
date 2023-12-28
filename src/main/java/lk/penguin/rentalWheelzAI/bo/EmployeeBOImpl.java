package lk.penguin.rentalWheelzAI.bo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lk.penguin.rentalWheelzAI.controller.EmployeeManageFormController;
import lk.penguin.rentalWheelzAI.controller.EmployeeRawFormController;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO{
    private EmployeeManageFormController employeeManageFormController;

    public EmployeeBOImpl(EmployeeManageFormController employeeManageFormController) {
        this.employeeManageFormController = employeeManageFormController;
    }
    @Override
    public void loadTableView() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<EmployeeDTO> dtos=new ArrayList<>();
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee");
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

        employeeManageFormController.getMainContainer().getChildren().add(root);

    }
}
