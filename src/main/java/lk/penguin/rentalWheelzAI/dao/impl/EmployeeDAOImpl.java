package lk.penguin.rentalWheelzAI.dao.impl;

import lk.penguin.rentalWheelzAI.dao.EmployeeDAO;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.entity.Employee;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET employeeName=?,empEmail=?,empNIC=?,empPosition=?,empAddress=?,empContact=? WHERE employeeId=?",
                employee.getEmployeeName(),
                employee.getEmpEmail(),
                employee.getEmpNIC(),
                employee.getEmpPosition(),
                employee.getEmpAddress(),
                employee.getEmpContact()
                );
    }
    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT employeeId FROM employee ORDER BY employeeId DESC LIMIT 1;");
        if(rst.next()){
            return rst.getString(1);

        }
        return null;
    }

    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?,?)",
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getEmpEmail(),
                employee.getEmpNIC(),
                employee.getEmpPosition(),
                employee.getEmpAddress(),
                employee.getEmpContact()
                );
    }
}
