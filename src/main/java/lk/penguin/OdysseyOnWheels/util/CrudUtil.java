package lk.penguin.OdysseyOnWheels.util;

import lk.penguin.OdysseyOnWheels.dao.SuperDAO;

import java.sql.SQLException;

public interface CrudUtil <T> extends SuperDAO {
    public boolean update(T dto) throws SQLException, ClassNotFoundException;

}
