package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.LocationsBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.LocationsDAO;
import lk.penguin.OdysseyOnWheels.dto.LocationsDTO;
import lk.penguin.OdysseyOnWheels.entity.Locations;

import javax.xml.stream.Location;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationsBOImpl implements LocationsBO {
    LocationsDAO locationsDAO=(LocationsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.LOCATIONS);
    @Override
    public ArrayList<LocationsDTO> getALL() throws SQLException, ClassNotFoundException {
        ArrayList<Locations> locations=locationsDAO.getAll();
        ArrayList<LocationsDTO> locationsDTOS=new ArrayList<>();
        for(Locations locations1:locations){
            LocationsDTO locationsDTO=new LocationsDTO(
                    locations1.getYardName(),
                    locations1.getStatus()
            );
            locationsDTOS.add(locationsDTO);
        }
        return locationsDTOS;
    }
}
