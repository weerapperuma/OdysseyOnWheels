package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.entity.Rent;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDAOImpl implements RentDAO {
    @Override
    public boolean save(Rent rent) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO rent(rentId, customerNIC,pickup_location,dropOff_location, rent_starting, rent_ending, order_date) VALUES(?,?,?,?,?,?,?)",
                rent.getRentId(),
                rent.getCustomerId(),
                rent.getPickupLocation(),
                rent.getDropOffLocation(),
                rent.getRentStarting(),
                rent.getRentEnding(),
                rent.getOrderDate()
        );
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

    @Override
    public Object get(String id) throws SQLException, ClassNotFoundException {
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
    public String getLastNumber() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT rentId FROM rent ORDER BY rentId DESC LIMIT 1");
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
