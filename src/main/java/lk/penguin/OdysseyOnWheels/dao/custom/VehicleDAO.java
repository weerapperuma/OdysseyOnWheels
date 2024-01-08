package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO extends CrudUtil {
    ArrayList<Vehicle> loadAll() throws SQLException, ClassNotFoundException;

    Vehicle get(String id) throws SQLException, ClassNotFoundException;
}
