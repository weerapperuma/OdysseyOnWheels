package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LanguageDAOImpl extends LanguageDAO {
    @Override
    public ArrayList get(String language,int nb) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT " + language + " FROM language WHERE wordSetNb=?";
        ResultSet resultSet=SQLUtil.execute(sqlQuery, nb);
        ArrayList arrayList=new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(resultSet.getString(1));
        }
        return arrayList;
    }
}
