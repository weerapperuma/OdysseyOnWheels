package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.penguin.OdysseyOnWheels.dao.custom.UserDAO;
import lk.penguin.OdysseyOnWheels.entity.User;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override

    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT * FROM user WHERE userName=?",id);
        return resultSet.next();
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User get(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM user WHERE userName=?",id);
        while (resultSet.next()){
            User user=new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
            return user;
        }return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> search(String text) throws SQLException, ClassNotFoundException {
        return null;
    }
}
