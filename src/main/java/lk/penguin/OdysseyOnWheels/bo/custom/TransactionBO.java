package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.scene.control.Label;
import lk.penguin.OdysseyOnWheels.bo.SuperBO;
import lk.penguin.OdysseyOnWheels.dto.RentDetailDTO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.io.IOException;
import java.sql.SQLException;

public interface TransactionBO extends SuperBO {
    boolean addToCart(VehicleDTO dto);

    void delete(String addedCartCarID) throws IOException;

    void reloadVbox() throws IOException;

    public boolean saveRentDetails(RentDetailDTO rentDetailDTO) throws SQLException, ClassNotFoundException;
}
