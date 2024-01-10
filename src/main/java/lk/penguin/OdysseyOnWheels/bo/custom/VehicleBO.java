package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    ArrayList<VehicleDTO> loadAllWithoutRented(String startingDay,String endingDay) throws SQLException, ClassNotFoundException;

    VehicleDTO get(String id) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO> getAll() throws SQLException, ClassNotFoundException;
}
