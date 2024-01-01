package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;
import lk.penguin.OdysseyOnWheels.dto.LanguageDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LanguageDAO extends SuperDAO {

    public String get(String language,int nb) throws SQLException, ClassNotFoundException;
}
