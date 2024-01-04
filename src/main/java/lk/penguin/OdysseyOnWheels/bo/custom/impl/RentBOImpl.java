package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.custom.RentBO;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.LocationsDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LocationsDAOImpl;
import lk.penguin.OdysseyOnWheels.entity.Locations;
import lk.penguin.OdysseyOnWheels.entity.Rent;

import java.sql.SQLException;
import java.util.ArrayList;

public class RentBOImpl implements RentBO {
    LanguageDAO languageDAO=new LanguageDAOImpl();
    LocationsDAO locationsDAO=new LocationsDAOImpl();

    @Override
    public ObservableList<String> getLanguageList() throws SQLException, ClassNotFoundException {
        return languageDAO.getAllLanguageList();
    }
    @Override
    public String get(String language,int nb) throws SQLException, ClassNotFoundException {
        return languageDAO.get(language,nb);
    }

    @Override
    public ObservableList<String> getLocations() throws SQLException, ClassNotFoundException {
        ArrayList<Locations> locations=locationsDAO.getAll();
        ObservableList<String> locatiosOB= FXCollections.observableArrayList();
        for(Locations location:locations){
            String location1=location.getYardName();
            locatiosOB.add(location1);
        }
        return locatiosOB;
    }
}
