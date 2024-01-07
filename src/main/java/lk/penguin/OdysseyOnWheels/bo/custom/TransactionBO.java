package lk.penguin.OdysseyOnWheels.bo.custom;

import javafx.scene.control.Label;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.io.IOException;

public interface TransactionBO {
    boolean addToCart(VehicleDTO dto);

    void delete(String addedCartCarID) throws IOException;

    void reloadVbox() throws IOException;
}
