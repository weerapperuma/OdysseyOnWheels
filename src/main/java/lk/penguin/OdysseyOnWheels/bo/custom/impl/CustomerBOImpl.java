package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.CustomerDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    @Override
    public ArrayList<CustomerDTO> loadTableView() throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> dtos= customerDAO.getAll();

        return dtos;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCustomerNIC(),
                dto.getCustomerName(),
                dto.getCustomerCountry(),
                dto.getCustomerEmail()));
    }
}
