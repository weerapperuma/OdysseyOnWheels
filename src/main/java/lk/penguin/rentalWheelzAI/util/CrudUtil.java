package lk.penguin.rentalWheelzAI.util;

import lk.penguin.rentalWheelzAI.dao.SuperDAO;
import lk.penguin.rentalWheelzAI.entity.Employee;

import java.sql.SQLException;

public interface CrudUtil <T> extends SuperDAO {
    public boolean update(T dto) throws SQLException, ClassNotFoundException;

}
