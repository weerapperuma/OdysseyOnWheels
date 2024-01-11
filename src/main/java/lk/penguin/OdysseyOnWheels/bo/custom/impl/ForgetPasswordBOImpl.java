package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.ForgetPasswordBO;
import lk.penguin.OdysseyOnWheels.controller.WelcomeFormController;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.UserDAO;
import lk.penguin.OdysseyOnWheels.entity.User;
import lk.penguin.OdysseyOnWheels.util.EmailUTIL;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Random;

public class ForgetPasswordBOImpl implements ForgetPasswordBO {
    UserDAO userDAO=(UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    @Override
    public String getOTP() throws SQLException, MessagingException, ClassNotFoundException {
        String otp=generateOTP();
        sendOTP(otp);
        return otp;
    }

    private void sendOTP(String otp) throws SQLException, ClassNotFoundException, MessagingException {
        User user=userDAO.get(WelcomeFormController.passportId);
        EmailUTIL.sendEmail(user.getUserEmail(),"Password Reset OTP for Admin loging",otp);
    }

    private String generateOTP() {
        Random random=new Random();
        String otp=String.valueOf(random.nextInt(10000000));
        return otp;
    }

    @Override
    public boolean update(String passportId, String text) throws SQLException, ClassNotFoundException {
        User user=userDAO.get(WelcomeFormController.passportId);
        return userDAO.update(new User(passportId,user.getUserName(),user.getUserNIC(),user.getUserMobile(),user.getUserEmail(),text));
    }
}
