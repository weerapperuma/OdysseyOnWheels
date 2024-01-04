package lk.penguin.OdysseyOnWheels.dao.custom;

import java.sql.SQLException;

public interface WelcomeBO {
    String get(String language, int nb) throws SQLException, ClassNotFoundException;
}
