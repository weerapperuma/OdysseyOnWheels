package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.CountriesDTO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDTO> loadTableView() throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    CustomerDTO get(String custId) throws SQLException, ClassNotFoundException;

    boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public ObservableList<String> countryList() throws SQLException, ClassNotFoundException;
}
