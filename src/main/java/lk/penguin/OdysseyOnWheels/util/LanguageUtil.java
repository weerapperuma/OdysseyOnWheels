package lk.penguin.OdysseyOnWheels.util;

import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;

import java.sql.SQLException;

public class LanguageUtil {
    public static String language="english";

    public static String get(String language, int nb) throws SQLException, ClassNotFoundException {
        LanguageDAO languageDAO=(LanguageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LANGUAGE);
        return languageDAO.get(language,nb);
    }
}
