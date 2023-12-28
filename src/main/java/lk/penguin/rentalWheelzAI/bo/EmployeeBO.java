package lk.penguin.rentalWheelzAI.bo;

import java.io.IOException;
import java.sql.SQLException;

public interface EmployeeBO {
    void loadTableView() throws SQLException, ClassNotFoundException, IOException;
}
