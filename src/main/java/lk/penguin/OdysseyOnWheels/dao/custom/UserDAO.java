package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.User;
import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;

public interface UserDAO extends CrudUtil<User> {
    public boolean isCheked(String id,String txtPassword) throws SQLException, ClassNotFoundException;

    boolean ifExists(String id) throws SQLException, ClassNotFoundException;
}
