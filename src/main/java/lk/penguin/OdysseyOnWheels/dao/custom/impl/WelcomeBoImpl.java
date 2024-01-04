package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.WelcomeBO;

import java.sql.SQLException;

public class WelcomeBoImpl implements WelcomeBO {
    LanguageDAO languageDAO=new LanguageDAOImpl();
    @Override
    public String get(String language, int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }
}
