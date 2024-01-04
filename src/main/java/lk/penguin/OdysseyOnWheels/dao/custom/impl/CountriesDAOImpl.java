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
        ArrayList<Countries> countries= new ArrayList<>();
        while (resultSet.next()){
            Countries countries1=new Countries(resultSet.getString(1));
            countries.add(countries1);
        }
        return countries;
    }
}
