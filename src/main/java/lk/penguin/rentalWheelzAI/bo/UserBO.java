package lk.penguin.rentalWheelzAI.bo;

import java.sql.SQLException;

public interface UserBO {
    boolean checkCredentials(String text, String txtPasswordText) throws SQLException, ClassNotFoundException;
}
