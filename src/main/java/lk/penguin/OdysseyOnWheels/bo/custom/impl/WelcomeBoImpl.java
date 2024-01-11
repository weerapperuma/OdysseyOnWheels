package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.CustomerDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.bo.custom.WelcomeBO;
import lk.penguin.OdysseyOnWheels.dao.custom.UserDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;
import lk.penguin.OdysseyOnWheels.entity.User;

import java.sql.SQLException;

public class WelcomeBoImpl implements WelcomeBO {
    CustomerDAO customerDAO=(CustomerDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
    LanguageDAO languageDAO=(LanguageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LANGUAGE);

    UserDAO userDAO=(UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    @Override
    public String get(String language, int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }

    @Override
    public boolean ifExistsCustomer(String text) throws SQLException, ClassNotFoundException {
        return customerDAO.ifExists(text);
    }

    @Override
    public boolean ifExistsUser(String text) throws SQLException, ClassNotFoundException {
        boolean ifexists=userDAO.ifExists(text);
        return userDAO.ifExists(text);
    }

    @Override
    public boolean chekCredentials(String userName,String text) throws SQLException, ClassNotFoundException {
        User user=userDAO.get(userName);
        return (text.equals(user.getUserPassword()));
    }

}
