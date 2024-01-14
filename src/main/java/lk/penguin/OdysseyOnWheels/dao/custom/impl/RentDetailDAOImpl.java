package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.controller.RentalCustomerFormController;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDetailDAO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.entity.RentDetail;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentDetailDAOImpl implements RentDetailDAO {
    @Override
    public boolean save(RentDetail rentDetail) throws SQLException, ClassNotFoundException {
        System.out.println("vehicle_id: "+rentDetail.getVehicleId());

        boolean isSaved = SQLUtil.execute("INSERT INTO rent_detail (rent_id,vehicle_id,rent_fee,excess_Mileage_cost ,start_date,end_date,order_date) VALUES(?,?,?,?,?,?,?);",
                rentDetail.getRentId(),
                rentDetail.getVehicleId(),
                rentDetail.getRentFee(),
                rentDetail.getExcessMileageCost(),
                rentDetail.getStartingDate(),
                rentDetail.getEndingDate(),
                rentDetail.getOrderDate());
        if (!isSaved) {
            TransactionUtil.rollBack();
            return false;
        }
        return true;

    }

    @Override
    public boolean update(RentDetail entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public RentDetail get(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<RentDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<RentDetail> search(String text) throws SQLException, ClassNotFoundException {
        return null;
    }
}
