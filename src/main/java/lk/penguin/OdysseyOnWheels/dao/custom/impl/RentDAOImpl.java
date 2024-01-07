package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.entity.Rent;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentDAOImpl implements RentDAO {
    @Override
    public boolean save(Rent rent) throws SQLException, ClassNotFoundException {
        System.out.println("save:"+rent.getCustomerId());
        return SQLUtil.execute("INSERT INTO rent(rentId, customerNIC, rent_first_amount, rent_second_amount, rent_starting, rent_ending, order_date) VALUES(?,?,?,?,?,?,?)",
                rent.getRentId(),
                rent.getCustomerId(),
                rent.getRentFirstAmount(),
                rent.getRentSecondAmount(),
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
    public String getLastNumber() throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT rentId FROM rent ORDER BY rentId DESC LIMIT 1");
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
