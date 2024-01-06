package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO {
    ArrayList<Vehicle> loadAll() throws SQLException, ClassNotFoundException;

    Vehicle get(String id);
}
