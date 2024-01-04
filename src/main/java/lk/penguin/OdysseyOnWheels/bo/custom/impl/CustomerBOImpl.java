package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.dao.custom.CountriesDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.CountriesDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.CustomerDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.CountriesDTO;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.entity.Countries;
import lk.penguin.OdysseyOnWheels.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO=new CustomerDAOImpl();
    CountriesDAO countriesDAO=new CountriesDAOImpl();
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

    @Override
    public CustomerDTO get(String custId) throws SQLException, ClassNotFoundException {
        return  customerDAO.get(custId);
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(customerDTO.getCustomerNIC(),customerDTO.getCustomerName(),customerDTO.getCustomerCountry(),customerDTO.getCustomerEmail()));
    }
    @Override

    public ObservableList<CountriesDTO> countryList() throws SQLException, ClassNotFoundException {
        ArrayList<Countries> countries= countriesDAO.getAll();
        ObservableList<CountriesDTO> countriesDTOS= FXCollections.observableArrayList();
        for(Countries country:countries){
            CountriesDTO countriesDTO=new CountriesDTO();
            countriesDTO.setCountryName(country.getCountryName());

            countriesDTOS.add(countriesDTO);
        }

        return countriesDTOS.sorted();
    }
}
