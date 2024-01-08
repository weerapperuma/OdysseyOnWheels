package lk.penguin.OdysseyOnWheels.dao.custom.impl;

import lk.penguin.OdysseyOnWheels.controller.RentalCustomerFormController;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDetailDAO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentDetailDAOImpl implements RentDetailDAO {
    @Override
    public boolean save(ArrayList<VehicleDTO> addToCartVboxList) throws SQLException, ClassNotFoundException {
        double fullRentTotal=0;
        System.out.println("Rent detail starting  :"+RentalCustomerFormController.rentStarting);
        System.out.println("Rent detail ending : "+RentalCustomerFormController.rentEnding);
        for(VehicleDTO dto:addToCartVboxList) {
            boolean isSaved = SQLUtil.execute("INSERT INTO rent_detail (rent_id,vehicle_id,rent_fee,start_date,end_date,order_date) VALUES(?,?,?,?,?,?);",
                    RentalCustomerFormController.rentId,
                    dto.getVehicleId(),
                    dto.getPerDay80Km(),
                    RentalCustomerFormController.rentStarting,
                    RentalCustomerFormController.rentEnding,
                    LocalDate.now());
            if (!isSaved) {
                TransactionUtil.rollBack();
                return false;
            }
            Double rentfee = Double.valueOf(dto.getPerDay80Km());
            fullRentTotal += rentfee;

            System.out.println(fullRentTotal);
        }
        return true;

    }
}
