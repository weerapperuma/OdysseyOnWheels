package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LanguageDAOImpl implements LanguageDAO {

    @Override
    public String get(String language,int nb) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT " + language + " FROM language WHERE wordSetNb=?";
        ResultSet resultSet=SQLUtil.execute(sqlQuery,nb);

        if (resultSet.next()) {
            return resultSet.getString(1);
        } else {
            return null;
        }
    }

    @Override
    public ObservableList<String> getAllLanguageList() throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME ='language' AND COLUMN_NAME <> 'wordSetNb'");
        ObservableList<String> languagesList= FXCollections.observableArrayList();
        while (rst.next()){
             String language=rst.getString(1);
            languagesList.add(language);
        }
        return languagesList;
    }
}
