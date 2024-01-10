package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.LocationsBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.LocationsBOImpl;
import lk.penguin.OdysseyOnWheels.dto.LocationsDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocationsFormController {

    @FXML
    private TextField addButtonFxId;

    @FXML
    private VBox locationVboxMainContainer;

    LocationsBO locationsBO=(LocationsBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.LOCATIONS);

    @FXML
    void txtAddLocationOnAction(ActionEvent event) {

    }
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<LocationsDTO> locationsDTOS=locationsBO.getALL();
        for(LocationsDTO locationsDTO:locationsDTOS){
            createRawLoadPane(locationsDTO);
        }
    }

    private void createRawLoadPane(LocationsDTO locationsDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(LocationsFormController.class.getResource("/view/locationRawForm.fxml"));
        Parent root=loader.load();
        LocationRawFormController locationRawFormController=loader.getController();

        locationRawFormController.setData(locationsDTO);

        locationVboxMainContainer.getChildren().add(root);
    }

}
