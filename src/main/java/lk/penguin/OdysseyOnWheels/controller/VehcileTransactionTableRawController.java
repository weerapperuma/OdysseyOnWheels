package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
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

    VehicleBO vehicleBo=new VehicleBOImpl();

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        VehicleDTO vehicleDTO=vehicleBo.get(lblVehiId.getText());
        System.out.println(vehicleDTO.getVehicleName());
        createRaw();
    }

    private void createRaw() throws IOException {
        FXMLLoader loader=new FXMLLoader(TransactionFormController.class.getResource("/view/addedCartForm.fxml"));
        Parent root=loader.load();
        AddedCartFormController addedCartFormController=loader.getController();
        addedCartFormController.setData(lblVehiId.getText());
        TransactionFormController.addCart.getChildren().add(root);
    }

    public void setData(VehicleDTO dto) {
        lblVehiId.setText(dto.getVehicleId());
        lblVehiType.setText(dto.getVehicleType());
        lblVehiName.setText(dto.getVehicleName());
        lblPerDayCost.setText(dto.getPerDay80Km());
        lblExcessMilageCost.setText(dto.getExcessMileage());
    }
}
