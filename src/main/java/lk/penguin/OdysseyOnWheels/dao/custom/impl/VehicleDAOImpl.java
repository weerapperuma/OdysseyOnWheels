package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.VehicleDAO;
import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public ArrayList<Vehicle> loadAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<Vehicle> vehicles=new ArrayList<>();
        while (resultSet.next()){
            vehicles.add(new Vehicle(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6)));
        }
        return vehicles;
    }

    @Override
    public Vehicle get(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id=?",id);
        while (rst.next()){
            Vehicle vehicle=new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getInt(6)
            );
            return vehicle;
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList search(String text) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Object dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(Object entity) throws SQLException, ClassNotFoundException {
        return false;
    }
}
