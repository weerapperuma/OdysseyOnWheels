package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentDetailDAO {
    boolean save(ArrayList<VehicleDTO> addToCartVboxList) throws SQLException, ClassNotFoundException;
}
