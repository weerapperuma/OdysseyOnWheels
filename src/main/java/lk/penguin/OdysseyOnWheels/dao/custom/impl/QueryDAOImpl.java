package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.dao.custom.QueryDAO;
import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<Vehicle> loadAll(String startingDay,String endingDay) throws SQLException, ClassNotFoundException {
        //ResultSet resultSet= SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id NOT IN (SELECT DISTINCT vehicle_id FROM rent_detail WHERE (start_date BETWEEN '2024-01-05' AND '2024-01-10') OR (end_date BETWEEN '2024-01-05' AND '2024-01-10') OR ('2024-01-05' BETWEEN start_date AND end_date) OR ('2024-01-10' BETWEEN start_date AND end_date));");
        ResultSet resultSet= SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id NOT IN (SELECT DISTINCT vehicle_id FROM rent_detail WHERE (start_date BETWEEN ? AND ?) OR (end_date BETWEEN ? AND ?) OR (? BETWEEN start_date AND end_date) OR (? BETWEEN start_date AND end_date));",startingDay,endingDay,startingDay,endingDay,startingDay,endingDay);
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

}
