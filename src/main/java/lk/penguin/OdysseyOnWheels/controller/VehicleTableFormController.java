package lk.penguin.OdysseyOnWheels.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.VehicleBOImpl;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleTableFormController {

    @FXML
    private ScrollPane vehicleTableScrolePane;

    @FXML
    private VBox vehicleTableVbox;

    VehicleBO vehicleBO=new VehicleBOImpl();

    public void initialize() throws SQLException, ClassNotFoundException, IOException {

        ArrayList<VehicleDTO> dtos= vehicleBO.loadAll();
        for (VehicleDTO dto:dtos){
            createRawLoadPane(dto);
        }
    }

    private void createRawLoadPane(VehicleDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(VehicleTableFormController.class.getResource("/view/VehcileTransactionTableRaw.fxml"));
        Parent root=loader.load();
        VehcileTransactionTableRawController controller=loader.getController();
        controller.setData(dto);
        this.vehicleTableVbox.getChildren().add(root);

    }

}
