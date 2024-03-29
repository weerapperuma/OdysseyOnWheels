package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.RentDTO;

import java.sql.SQLException;
import java.sql.Savepoint;

public interface RentBO extends SuperBO {
    ObservableList<String> getLanguageList() throws SQLException, ClassNotFoundException;

    String get(String language, int nb) throws SQLException, ClassNotFoundException;

    ObservableList getLocations() throws SQLException, ClassNotFoundException;

    String generateId() throws SQLException, ClassNotFoundException;

    boolean save(RentDTO rentDTO) throws SQLException, ClassNotFoundException;
}
