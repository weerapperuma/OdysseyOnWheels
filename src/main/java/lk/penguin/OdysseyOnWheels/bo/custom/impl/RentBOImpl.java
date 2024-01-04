package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.custom.RentBO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;

import java.sql.SQLException;

public class RentBOImpl implements RentBO {
    LanguageDAO languageDAO=new LanguageDAOImpl();
    @Override
    public ObservableList<String> getLanguageList() throws SQLException, ClassNotFoundException {
        return languageDAO.getAllLanguageList();
    }
}
