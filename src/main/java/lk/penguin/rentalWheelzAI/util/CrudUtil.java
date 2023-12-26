package lk.penguin.rentalWheelzAI.util;

import java.sql.SQLException;

public interface CrudUtil {
    public boolean isExists(String id) throws SQLException, ClassNotFoundException;

    String isCheked(String id) throws SQLException, ClassNotFoundException;
}
