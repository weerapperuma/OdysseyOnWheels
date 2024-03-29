package lk.penguin.OdysseyOnWheels.dao.custom;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.dao.SuperDAO;

import java.sql.SQLException;

public interface LanguageDAO extends SuperDAO {

    String get(String language,int nb) throws SQLException, ClassNotFoundException;

    ObservableList<String> getAllLanguageList() throws SQLException, ClassNotFoundException;
}
