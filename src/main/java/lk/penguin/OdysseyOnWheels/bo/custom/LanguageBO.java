package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LanguageBO extends SuperBO {


    public String get(String language,int nb) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getLanguageList() throws SQLException, ClassNotFoundException;
}
