package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.LanguageBO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class LanguageBOImpl extends LanguageBO {
    LanguageDAO languageDAO=new LanguageDAOImpl();
    @Override
    public ArrayList get(String language,int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }
}
