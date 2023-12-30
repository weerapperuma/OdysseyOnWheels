package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.UserBO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.UserDAOImpl;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAOImpl userDAO= new UserDAOImpl();

    public boolean checkCredentials(String text, String txtPasswordText) throws SQLException, ClassNotFoundException {
        boolean isCredential=userDAO.isCheked(text,txtPasswordText);
        System.out.println(isCredential+" user name");
        if(isCredential){
            return true;
        }
        else{
            return false;
        }
    }
}
