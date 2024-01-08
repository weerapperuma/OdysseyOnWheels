package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean checkCredentials(String text, String txtPasswordText) throws SQLException, ClassNotFoundException;

    boolean ifExists(String id) throws SQLException, ClassNotFoundException;
}
