package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.penguin.OdysseyOnWheels.bo.custom.RentBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.LanguageDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.LocationsDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LanguageDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.LocationsDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.RentDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.RentDTO;
import lk.penguin.OdysseyOnWheels.entity.Locations;
import lk.penguin.OdysseyOnWheels.entity.Rent;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class RentBOImpl implements RentBO {
    LanguageDAO languageDAO=(LanguageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LANGUAGE);
    LocationsDAO locationsDAO=(LocationsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LOCATIONS);

    RentDAO rentDAO=(RentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.RENT);

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

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        String lastNumber=rentDAO.getLastNumber();
        if(lastNumber!=null){
            int newLastnb=Integer.parseInt(lastNumber.substring(2))+1;
            return String.format("R-%05d", newLastnb);
        }
        else {
            return "R-00001";
        }
    }

    @Override
    public boolean save(RentDTO rentDTO) throws SQLException, ClassNotFoundException {
        TransactionUtil.startTransaction();
        boolean isSaved= rentDAO.save(new Rent(rentDTO.getRentId(),rentDTO.getCustomerId(),rentDTO.getPickupLocation(),rentDTO.getDropOffLocation(), rentDTO.getRentStarting(),rentDTO.getRentEnding(),rentDTO.getOrderDate()));
        if(!isSaved){
            TransactionUtil.rollBack();
            TransactionUtil.endTransaction();
        }
        return true;
    }
}
