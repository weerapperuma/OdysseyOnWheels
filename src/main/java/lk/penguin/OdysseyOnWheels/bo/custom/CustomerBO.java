package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO {
    void loadTableView(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
}
