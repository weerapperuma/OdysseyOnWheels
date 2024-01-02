package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LanguageDAO extends SuperDAO {

    String get(String language,int nb) throws SQLException, ClassNotFoundException;
}
