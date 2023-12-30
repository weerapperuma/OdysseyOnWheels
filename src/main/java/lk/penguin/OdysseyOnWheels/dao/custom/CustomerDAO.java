package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {

    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
}
