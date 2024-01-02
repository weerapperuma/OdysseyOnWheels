package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;
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
}
