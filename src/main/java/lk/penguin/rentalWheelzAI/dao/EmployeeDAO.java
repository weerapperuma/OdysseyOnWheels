package lk.penguin.rentalWheelzAI.dao;

import lk.penguin.rentalWheelzAI.entity.Employee;
import lk.penguin.rentalWheelzAI.util.CrudUtil;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudUtil<Employee> {

    String generateNewId() throws SQLException, ClassNotFoundException;
}
