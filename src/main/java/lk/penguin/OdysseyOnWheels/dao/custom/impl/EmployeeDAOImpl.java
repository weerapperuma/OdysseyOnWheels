package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.EmployeeDAO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.entity.Employee;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM employee WHERE employeeId=?",id);
        return resultSet.next();
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

    @Override
    public Employee get(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM employee WHERE employeeId=?",id);
        if (resultSet.next()){
            Employee employee=new Employee(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
            return employee;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE employeeId=?",id);
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees=new ArrayList<>();
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM employee");
        while (resultSet.next()){
            Employee employee=new Employee(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public ArrayList<Employee> search(String text) throws SQLException, ClassNotFoundException {
        ArrayList<Employee> employees=new ArrayList<>();
        ResultSet resultSet;
        resultSet=SQLUtil.execute("SELECT * FROM employee WHERE SUBSTRING_INDEX(employeeName, ' ', -1) LIKE ?;",("%"+text+"%"));
        if(!resultSet.next()){
            resultSet=SQLUtil.execute("SELECT * FROM employee WHERE employeeId LIKE ?;","%"+text+"%");
        }
        while (resultSet.next()){
            Employee employee=new Employee(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
            employees.add(employee);
        }
        return employees;
    }
}
