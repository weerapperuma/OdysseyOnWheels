package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO>dtos=new ArrayList<>();

        while (resultSet.next()){
            CustomerDTO customerDTO=new CustomerDTO();
            customerDTO.setCustomerNIC(resultSet.getString("customerNIC"));
            customerDTO.setCustomerName(resultSet.getString("customerName"));
            customerDTO.setCustomerCountry(resultSet.getString("customerCountry"));
            customerDTO.setCustomerEmail(resultSet.getString("customerEmail"));
            dtos.add(customerDTO);
        }

        return dtos;
    }
}
