package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.LanguageBO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LanguageBOImpl implements LanguageBO {
    public static String language="english";
    LanguageDAO languageDAO=new LanguageDAOImpl();
    @Override
    public String get(String language,int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }
}
