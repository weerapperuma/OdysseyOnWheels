package lk.penguin.rentalWheelzAI.bo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lk.penguin.rentalWheelzAI.controller.EmployeeManageFormController;
import lk.penguin.rentalWheelzAI.controller.EmployeeRawFormController;
import lk.penguin.rentalWheelzAI.dao.EmployeeDAO;
import lk.penguin.rentalWheelzAI.dao.impl.EmployeeDAOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.entity.Employee;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO{
    private EmployeeManageFormController employeeManageFormController;
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();


    public EmployeeBOImpl(EmployeeManageFormController employeeManageFormController) {
        this.employeeManageFormController = employeeManageFormController;
    }
    @Override
    public void loadTableView() throws SQLException, ClassNotFoundException, IOException {
        String query="SELECT * FROM employee";
        ArrayList<EmployeeDTO>dtos=loadALl(query);

        for(EmployeeDTO dto:dtos){
            createEmployeeRawLoadPane(dto);
        }
    }
    @Override
    public ArrayList<EmployeeDTO> loadALl(String query) throws SQLException, ClassNotFoundException {

        ResultSet rst= SQLUtil.execute(query);
        ArrayList<EmployeeDTO> dtos=new ArrayList<>();
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
        return dtos;
    }

    private void createEmployeeRawLoadPane(EmployeeDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(EmployeeManageFormController.class.getResource("/view/employeeRawForm.fxml"));
        Parent root=loader.load();
        EmployeeRawFormController controller=loader.getController();

        controller.setData(dto);

        employeeManageFormController.getMainContainer().getChildren().add(root);

    }
    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        System.out.println(dto.getEmployeeName());
        System.out.println(dto.getEmployeeId());
        return SQLUtil.execute("UPDATE employee SET employeeName=?,empEmail=?,empNIC=?,empPosition=?, empAddress=?,empContact=? WHERE employeeId=?",
                dto.getEmployeeName(),
                dto.getEmpEmail(),
                dto.getEmpNIC(),
                dto.getEmpPosition(),
                dto.getEmpAddress(),
                dto.getEmpContact(),
                dto.getEmployeeId()
                );
    }
    @Override
    public ArrayList<EmployeeDTO> showAll(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM employee WHERE employeeId=?",id);
        ArrayList<EmployeeDTO> dtos=new ArrayList<>();
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
        return dtos;
    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return employeeDAO.generateNewId();
    }

    @Override
    public boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmpEmail(),
                employeeDTO.getEmpNIC(),
                employeeDTO.getEmpPosition(),
                employeeDTO.getEmpAddress(),
                employeeDTO.getEmpContact()));
    }
}
