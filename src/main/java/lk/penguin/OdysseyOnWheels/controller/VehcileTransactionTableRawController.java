package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.TransactionBO;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.TransactionBOImpl;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.VehicleBOImpl;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.io.IOException;
import java.sql.SQLException;

public class VehcileTransactionTableRawController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label lblExcessMilageCost;

    @FXML
    private Label lblPerDayCost;

    @FXML
    private Label lblVehiId;

    @FXML
    private Label lblVehiName;

    @FXML
    private Label lblVehiType;

    @FXML
    private AnchorPane vehickeTransaxtionRaw;

    VehicleBO vehicleBo=(VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEHICLE);
    TransactionBO transactionBO=(TransactionBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.TRANSACTION);

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        VehicleDTO vehicleDTO=vehicleBo.get(lblVehiId.getText());
        System.out.println(vehicleDTO.getVehicleName());
        boolean isAdded=transactionBO.addToCart(vehicleDTO);
        if(isAdded){
            transactionBO.reloadVbox();
        }
    }



    public void setData(VehicleDTO dto) {
        lblVehiId.setText(dto.getVehicleId());
        lblVehiType.setText(dto.getVehicleType());
        lblVehiName.setText(dto.getVehicleName());
        lblPerDayCost.setText(Double.toString(dto.getPerDay80Km()));
        lblExcessMilageCost.setText(Double.toString(dto.getExcessMileage()));
    }
}
