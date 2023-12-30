package lk.penguin.OdysseyOnWheels.bo.custom;

import java.sql.SQLException;

public interface UserBO {
    boolean checkCredentials(String text, String txtPasswordText) throws SQLException, ClassNotFoundException;

}
