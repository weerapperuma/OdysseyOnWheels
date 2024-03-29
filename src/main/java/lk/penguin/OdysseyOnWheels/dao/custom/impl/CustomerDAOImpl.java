package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import javafx.scene.control.Alert;
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
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer>customers=new ArrayList<>();

        while (resultSet.next()){
            Customer customer=new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
                    );
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public boolean delete(String id){
        try {
            return SQLUtil.execute("DELETE FROM Customer WHERE customerNIC=?",id);
        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Deleting Customer");
            alert.setContentText("Customer is already in the rent");
            alert.show();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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
    public Customer get(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("Select * from customer Where customerNIC=?",id);
        while (rst.next()){
            Customer customer=new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            return customer;
        }
        return null;
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
    @Override
    public ArrayList<Customer> search(String text) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers=new ArrayList<>();
        ResultSet resultSet;
        resultSet=SQLUtil.execute("SELECT * FROM customer WHERE customerName LIKE ?;","%"+text+"%");
        if(!resultSet.next()){
            resultSet=SQLUtil.execute("SELECT * FROM customer WHERE customerNIC LIKE ?;","%"+text+"%");
        }
        while (resultSet.next()){
            Customer customer=new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            customers.add(customer);
        }
        return  customers;

    }
}
