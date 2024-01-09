package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.dao.custom.CountriesDAO;
import lk.penguin.OdysseyOnWheels.entity.Countries;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountriesDAOImpl implements CountriesDAO {
    @Override
    public ArrayList<Countries> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT * FROM countries");
        ArrayList<Countries> countriesList= new ArrayList<>();
        while (resultSet.next()){
            Countries countries=new Countries(resultSet.getString(1));
            countriesList.add(countries);
        }
        return countriesList;
    }
}
