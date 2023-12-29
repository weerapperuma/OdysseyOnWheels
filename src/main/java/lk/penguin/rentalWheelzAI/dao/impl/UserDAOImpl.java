package lk.penguin.rentalWheelzAI.dao.impl;

import javafx.scene.control.Alert;
import lk.penguin.rentalWheelzAI.dao.UserDAO;
import lk.penguin.rentalWheelzAI.dto.UserDTO;
import lk.penguin.rentalWheelzAI.entity.User;
import lk.penguin.rentalWheelzAI.util.CrudUtil;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

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
}
