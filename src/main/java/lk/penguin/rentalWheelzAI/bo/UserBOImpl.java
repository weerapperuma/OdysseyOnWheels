package lk.penguin.rentalWheelzAI.bo;

import lk.penguin.rentalWheelzAI.dao.UserDAO;
import lk.penguin.rentalWheelzAI.dao.impl.UserDAOImpl;

import java.sql.SQLException;

public class UserBOImpl implements UserBO{
    UserDAOImpl userDAO= new UserDAOImpl() {
        @Override
        public String isCheked(String id) throws SQLException, ClassNotFoundException {
            return null;
        }

        @Override
        public boolean isExists(String id) throws SQLException, ClassNotFoundException {
            return false;
        }
    };
    public boolean checkCredentials(String text, String txtPasswordText) throws SQLException, ClassNotFoundException {
        boolean isExist=userDAO.isExists(text);
        System.out.println(isExist+" user name");
        if(isExist){
            System.out.println("Dan inne password chek krnna kalin");
            String password=userDAO.isCheked(text);
            if(password.equals(txtPasswordText)){
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }
}
