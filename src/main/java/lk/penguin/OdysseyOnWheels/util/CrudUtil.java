package lk.penguin.OdysseyOnWheels.util;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudUtil <T> extends SuperDAO {
    boolean update(T entity) throws SQLException, ClassNotFoundException;
    boolean ifExists(String id) throws SQLException, ClassNotFoundException;
    boolean save(T entity) throws SQLException, ClassNotFoundException;
    T get(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;


}
