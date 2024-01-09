package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.CountriesDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.CountriesDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.CustomerDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Countries;
import lk.penguin.OdysseyOnWheels.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO=(CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
    CountriesDAO countriesDAO=(CountriesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.COUNTRIES);
    @Override
    public ArrayList<CustomerDTO> loadTableView() throws SQLException, ClassNotFoundException {

        ArrayList<Customer> customers= customerDAO.getAll();
        ArrayList<CustomerDTO>customerDTOS=new ArrayList<>();
        for(Customer customer:customers){
            CustomerDTO customerDTO=new CustomerDTO(
                    customer.getCustomerNIC(),
                    customer.getCustomerName(),
                    customer.getCustomerCountry(),
                    customer.getCustomerEmail()
                    );
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;
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

    @Override
    public CustomerDTO get(String id) throws SQLException, ClassNotFoundException {
        Customer customer=customerDAO.get(id);
        return  new CustomerDTO(
                customer.getCustomerNIC(),
                customer.getCustomerName(),
                customer.getCustomerCountry(),
                customer.getCustomerEmail());
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(customerDTO.getCustomerNIC(),customerDTO.getCustomerName(),customerDTO.getCustomerCountry(),customerDTO.getCustomerEmail()));
    }
    @Override
    public ObservableList<String> countryList() throws SQLException, ClassNotFoundException {
        ArrayList<Countries> countries= countriesDAO.getAll();
        ObservableList<String> countriesList= FXCollections.observableArrayList();
        for(Countries country:countries){
            String countryNames=country.getCountryName();
            countriesList.add(countryNames);
        }
        return countriesList;
    }
    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.ifExists(id);
    }
}
