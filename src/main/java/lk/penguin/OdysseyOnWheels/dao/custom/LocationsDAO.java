package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;
import lk.penguin.OdysseyOnWheels.entity.Locations;
import lk.penguin.OdysseyOnWheels.entity.Rent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocationsDAO extends SuperDAO {

    public ArrayList<Locations> getAll() throws SQLException, ClassNotFoundException;
}
