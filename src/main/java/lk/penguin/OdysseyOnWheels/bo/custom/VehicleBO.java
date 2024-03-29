package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO extends SuperBO {
    ArrayList<VehicleDTO> loadAllWithoutRented(String startingDay,String endingDay) throws SQLException, ClassNotFoundException;

    VehicleDTO get(String id) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean update(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;

    boolean delete(String text) throws SQLException, ClassNotFoundException;

    boolean ifExists(String text) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDTO> search(String text) throws SQLException, ClassNotFoundException;

    boolean save(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
}
