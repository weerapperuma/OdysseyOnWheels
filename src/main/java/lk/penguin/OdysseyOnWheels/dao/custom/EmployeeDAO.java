package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.Employee;
import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudUtil<Employee> {

    String generateNewId() throws SQLException, ClassNotFoundException;

    public boolean save(Employee employee) throws SQLException, ClassNotFoundException;
}
