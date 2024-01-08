package lk.penguin.OdysseyOnWheels.dao.custom;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.dao.SuperDAO;
import lk.penguin.OdysseyOnWheels.entity.Countries;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CountriesDAO extends SuperDAO {
    ArrayList<Countries> getAll() throws SQLException, ClassNotFoundException;
}
