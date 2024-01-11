package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.UserBO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.UserDAOImpl;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAOImpl userDAO= new UserDAOImpl();
    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return userDAO.ifExists(id);
    }
}
