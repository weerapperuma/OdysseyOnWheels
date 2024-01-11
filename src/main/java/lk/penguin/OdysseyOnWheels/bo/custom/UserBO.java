package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {

    boolean ifExists(String id) throws SQLException, ClassNotFoundException;
}
