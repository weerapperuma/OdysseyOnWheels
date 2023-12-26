package lk.penguin.rentalWheelzAI.dao;

import lk.penguin.rentalWheelzAI.entity.User;
import lk.penguin.rentalWheelzAI.util.CrudUtil;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.sql.SQLException;

public interface UserDAO extends CrudUtil {
    public String isCheked(String id) throws SQLException, ClassNotFoundException;

}
