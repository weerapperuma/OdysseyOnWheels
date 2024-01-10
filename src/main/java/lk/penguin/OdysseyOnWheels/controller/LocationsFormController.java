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
    void txtAddLocationOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(addButtonFxId.getLength()!=0){
            boolean isSaved=locationsBO.save(new LocationsDTO(0,addButtonFxId.getText(),"Available"));
            if(isSaved){
                System.out.println("location saved");
                locationVboxMainContainer.getChildren().clear();
                createRawLoadPane();
            }
        }
    }
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        createRawLoadPane();
    }

    private void createRawLoadPane() throws IOException, SQLException, ClassNotFoundException {
        ArrayList<LocationsDTO> locationsDTOS=locationsBO.getALL();
        for(LocationsDTO locationsDTO:locationsDTOS){
            FXMLLoader loader=new FXMLLoader(LocationsFormController.class.getResource("/view/locationRawForm.fxml"));
            Parent root=loader.load();
            LocationRawFormController locationRawFormController=loader.getController();

            locationRawFormController.setData(locationsDTO);

            locationVboxMainContainer.getChildren().add(root);
        }

    }

}
