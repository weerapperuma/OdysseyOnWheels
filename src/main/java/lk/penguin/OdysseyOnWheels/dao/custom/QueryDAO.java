package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {

    ArrayList<Vehicle> loadAll() throws SQLException, ClassNotFoundException;
}
