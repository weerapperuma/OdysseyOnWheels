package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.OdysseyOnWheels.bo.custom.TransactionBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.TransactionBOImpl;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.io.IOException;

public class AddedCartFormController {

    @FXML
    private Label addedCartCarID;
    TransactionBO transactionBO=new TransactionBOImpl();

    @FXML
    void btnAddedCarDeleteOnAction(ActionEvent event) throws IOException {
        transactionBO.delete(this.addedCartCarID.getText());

    }

    public void setData(VehicleDTO dto) {
        System.out.println(dto.getVehicleName());

        addedCartCarID.setText(dto.getVehicleId());
    }
}
