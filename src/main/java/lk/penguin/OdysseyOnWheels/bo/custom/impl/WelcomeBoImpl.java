package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.bo.custom.WelcomeBO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;

import java.sql.SQLException;

public class WelcomeBoImpl implements WelcomeBO {
    LanguageDAO languageDAO=(LanguageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LANGUAGE);
    @Override
    public String get(String language, int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }
    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return userDAO.ifExists(id);
    }
}
