package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {

    boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException;


    ArrayList<EmployeeDTO> showAll(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean save(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException;
}
