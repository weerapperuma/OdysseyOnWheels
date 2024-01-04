package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.LocationsDAO;
import lk.penguin.OdysseyOnWheels.entity.Locations;
import lk.penguin.OdysseyOnWheels.entity.Rent;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationsDAOImpl implements LocationsDAO {

    @Override
    public ArrayList<Locations> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM locations");
        ArrayList<Locations> locations=new ArrayList<>();
        while (rst.next()){
            Locations entity=new Locations(rst.getString(1));
            locations.add(entity);
        }
        return locations;
    }
}
