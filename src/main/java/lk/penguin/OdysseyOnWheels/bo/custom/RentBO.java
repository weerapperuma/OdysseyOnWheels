package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface RentBO {
    ObservableList<String> getLanguageList() throws SQLException, ClassNotFoundException;
}
