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
    public boolean update(Locations entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE locations SET locations=?,customerName=?,customerCountry=?, customerEmail=? WHERE customerNIC=?;
    }

    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Locations entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO locations VALUES (?,?)",entity.getYardName(),entity.getStatus());
    }

    @Override
    public Locations get(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Locations> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT * FROM locations");
        ArrayList<Locations> locations=new ArrayList<>();
        while (rst.next()){
            Locations entity=new Locations(rst.getString(1),rst.getString(2));
            locations.add(entity);
        }
        return locations;
    }

    @Override
    public ArrayList<Locations> search(String text) throws SQLException, ClassNotFoundException {
        return null;
    }
}
