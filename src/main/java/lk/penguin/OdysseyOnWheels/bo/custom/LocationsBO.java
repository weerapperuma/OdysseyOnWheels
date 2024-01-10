package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.LocationsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocationsBO extends SuperBO {
    ArrayList<LocationsDTO> getALL() throws SQLException, ClassNotFoundException;

    boolean save(LocationsDTO locationsDTO) throws SQLException, ClassNotFoundException;
}
