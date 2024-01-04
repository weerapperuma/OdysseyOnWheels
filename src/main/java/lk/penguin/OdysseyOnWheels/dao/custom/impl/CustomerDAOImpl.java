package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Customer;
import lk.penguin.OdysseyOnWheels.entity.Employee;
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

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE customerNIC=?",id);
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET customerNIC=?,customerName=?,customerCountry=?, customerEmail=? WHERE customerNIC=?",
                customer.getCustomerNIC(),
                customer.getCustomerName(),
                customer.getCustomerCountry(),
                customer.getCustomerEmail(),
                customer.getCustomerNIC()

        );
    }

    @Override
    public CustomerDTO get(String custId) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("Select * from customer Where customerNIC=?",custId);
        CustomerDTO customerDTO = null;
        while (rst.next()){
            customerDTO=new CustomerDTO(
                rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            );
        }
        return customerDTO;
    }

    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO customer VALUES (?,?,?,?)",
                customer.getCustomerNIC(),
                customer.getCustomerName(),
                customer.getCustomerCountry(),
                customer.getCustomerEmail()
        );
    }

    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("Select * from customer WHERE customerNIC=?",id);
        return rst.next();
    }
}
