package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudUtil {

    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    boolean update(Customer customer) throws SQLException, ClassNotFoundException;

    CustomerDTO get(String custId) throws SQLException, ClassNotFoundException;

    boolean save(Customer customer) throws SQLException, ClassNotFoundException;

    boolean ifExists(String id) throws SQLException, ClassNotFoundException;
}
