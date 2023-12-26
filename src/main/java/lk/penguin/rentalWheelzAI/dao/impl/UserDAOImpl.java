package lk.penguin.rentalWheelzAI.dao.impl;

import lk.penguin.rentalWheelzAI.util.CrudUtil;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.sql.SQLException;

public class UserDAOImpl implements CrudUtil {
    @Override
    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        boolean b=SQLUtil.execute("SELECT * FROM user WHERE userId=?",id);
        System.out.println(b+"hello");
        return b;
    }
    @Override
    public String isCheked(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT userPassword FROM user WHERE userId=?",id);
    }
}
