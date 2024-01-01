package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class LanguageDAO implements SuperDAO {



    public abstract ArrayList get(String language, int nb) throws SQLException, ClassNotFoundException;
}
