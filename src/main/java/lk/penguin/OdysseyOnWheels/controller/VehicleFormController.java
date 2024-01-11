package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleFormController {

    @FXML
    private TextField txtVehicleSearchFx;

    @FXML
    private VBox vboxMainContainer;

    VehicleBO vehicleBO=(VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEHICLE);

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Navigation.closePopup();
    }
    @FXML
    void txtVehicleOnAction(ActionEvent event) {

    }
    public void initialize() throws SQLException, IOException, ClassNotFoundException {
        createRawLoadPane();
    }

    private void createRawLoadPane() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<VehicleDTO> vehicleDTOS=vehicleBO.getAll();
        for(VehicleDTO dto:vehicleDTOS){
            FXMLLoader loader=new FXMLLoader(VehicleFormController.class.getResource("/view/vehicleRawForm.fxml"));
            Parent root=loader.load();
            VehicleRawFormController vehicleRawFormController=loader.getController();

            vehicleRawFormController.setData(dto);


            vboxMainContainer.getChildren().add(root);
        }
    }

}
