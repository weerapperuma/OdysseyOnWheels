package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO {
    ArrayList<VehicleDTO> loadAll() throws SQLException, ClassNotFoundException;

    VehicleDTO get(String id) throws SQLException, ClassNotFoundException;
}
