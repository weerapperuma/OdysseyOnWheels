package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.penguin.OdysseyOnWheels.dao.custom.VehicleDAO;
import lk.penguin.OdysseyOnWheels.entity.Employee;
import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {

    @Override
    public boolean update(Vehicle entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE vehicle SET vehicle_type=?,vehicle_name=?,per_day_80km=?,excess_mileage=?,status=? WHERE vehicle_id=?",
                entity.getVehicleType(),
                entity.getVehicleName(),
                entity.getPerDay80Km(),
                entity.getExcessMileage(),
                entity.getStatus(),
                entity.getVehicleId());
    }

    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id=?",id);
        return rst.next();
    }

    @Override
    public boolean save(Vehicle entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO vehicle VALUES (?,?,?,?,?,?)",
                entity.getVehicleId(),
                entity.getVehicleType(),
                entity.getVehicleName(),
                entity.getPerDay80Km(),
                entity.getExcessMileage(),
                entity.getStatus());
    }

    @Override
    public Vehicle get(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id=?",id);
        while (rst.next()){
            Vehicle vehicle=new Vehicle(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getInt(6)
            );
            return vehicle;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        try {
            return SQLUtil.execute("DELETE FROM vehicle WHERE vehicle_id=?",id);
        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error Deleting Vehicle");
            alert.setContentText("Vehicle is already in the rent");
            alert.show();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM vehicle");
        ArrayList<Vehicle> vehicles=new ArrayList<>();
        while (resultSet.next()){
            Vehicle vehicle=new Vehicle(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getInt(6)
            );
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    @Override
    public ArrayList<Vehicle> search(String text) throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles=new ArrayList<>();

        ResultSet resultSet=SQLUtil.execute("SELECT * FROM vehicle WHERE vehicle_id=?",text);
        while (resultSet.next()){
            Vehicle vehicle=new Vehicle(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getInt(6)
            );
            vehicles.add(vehicle);
        }
        return vehicles;
    }


}
