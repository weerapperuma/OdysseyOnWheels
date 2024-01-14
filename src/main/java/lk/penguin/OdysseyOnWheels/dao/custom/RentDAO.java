package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.entity.Rent;
import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;

public interface RentDAO extends CrudUtil<Rent> {
    String getLastNumber() throws SQLException, ClassNotFoundException;

    boolean save(Rent rent) throws SQLException, ClassNotFoundException;
}
