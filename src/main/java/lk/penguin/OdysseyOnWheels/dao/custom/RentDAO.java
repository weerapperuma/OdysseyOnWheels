package lk.penguin.OdysseyOnWheels.dao.custom;

import lk.penguin.OdysseyOnWheels.util.CrudUtil;

import java.sql.SQLException;

public interface RentDAO extends CrudUtil {
    String getLastNumber() throws SQLException, ClassNotFoundException;
}
