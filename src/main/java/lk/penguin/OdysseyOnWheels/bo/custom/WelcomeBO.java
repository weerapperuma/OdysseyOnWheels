package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;

import java.sql.SQLException;

public interface WelcomeBO extends SuperBO {
    boolean ifExistsCustomer(String text) throws SQLException, ClassNotFoundException;

    boolean ifExistsUser(String text) throws SQLException, ClassNotFoundException;

    boolean chekCredentials(String userName,String text) throws SQLException, ClassNotFoundException;
}
