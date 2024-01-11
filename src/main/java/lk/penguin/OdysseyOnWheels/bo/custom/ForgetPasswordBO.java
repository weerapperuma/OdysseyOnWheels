package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;

import javax.mail.MessagingException;
import java.sql.SQLException;

public interface ForgetPasswordBO extends SuperBO {
    String getOTP() throws SQLException, MessagingException, ClassNotFoundException;

    boolean update(String passportId, String text) throws SQLException, ClassNotFoundException;
}
