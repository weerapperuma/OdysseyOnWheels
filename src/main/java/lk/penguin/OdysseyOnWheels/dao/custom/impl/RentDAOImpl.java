package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentDAOImpl implements RentDAO {
    @Override
    public boolean update(Object dto) throws SQLException, ClassNotFoundException {
        return false;
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
