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
    public boolean isCheked(String id,String txtPassword) throws SQLException, ClassNotFoundException {
        ResultSet rst =SQLUtil.execute("SELECT userPassword FROM user WHERE userName=?",id);

        if(rst.next()){
            String pw=rst.getString("userPassword");
            if(pw.equals(txtPassword)){
                return true;
            }
            else {
                new Alert(Alert.AlertType.ERROR,"Invalid Password").show();
            }
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Invalid User Name").show();
        }
        return false;
    }


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
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
