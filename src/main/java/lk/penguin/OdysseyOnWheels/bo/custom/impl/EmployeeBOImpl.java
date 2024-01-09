package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.EmployeeBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.EmployeeDAO;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;
import lk.penguin.OdysseyOnWheels.entity.Employee;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO=(EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.EMPLOYEE);


    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
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
        String lastId=employeeDAO.generateNewId();
        if(lastId!=null){
            String lastNumber=lastId.substring(1);
            int newLastNumber=Integer.parseInt(lastNumber)+1;
            String out=String.format("E%03d",newLastNumber);
            return out;
        }
        else {
            return "E001";
        }
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

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees=employeeDAO.getAll();
        ArrayList<EmployeeDTO> employeeDTOS=new ArrayList<>();
        for(Employee employee:employees){
            EmployeeDTO employeeDTO=new EmployeeDTO(
                    employee.getEmployeeId(),
                    employee.getEmployeeName(),
                    employee.getEmpEmail(),
                    employee.getEmpNIC(),
                    employee.getEmpPosition(),
                    employee.getEmpAddress(),
                    employee.getEmpContact()
            );
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }

    @Override
    public ArrayList<EmployeeDTO> search(String text) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees=employeeDAO.search(text);
        System.out.println("Employee bo "+employees.size());
        ArrayList<EmployeeDTO>employeeDTOS=new ArrayList<>();
        for(Employee employee:employees){
            EmployeeDTO employeeDTO=new EmployeeDTO(
                    employee.getEmployeeId(),
                    employee.getEmployeeName(),
                    employee.getEmpEmail(),
                    employee.getEmpNIC(),
                    employee.getEmpPosition(),
                    employee.getEmpAddress(),
                    employee.getEmpContact()
            );
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }
}
