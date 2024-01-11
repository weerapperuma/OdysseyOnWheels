package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.sql.SQLException;
import java.util.Set;

public class SaveNewVehicleFormController {

    @FXML
    private JFXButton btnVehicleExitOnAction;

    @FXML
    private JFXComboBox<Integer> cmbStatusFX;

    @FXML
    private JFXComboBox<String> cmbTypeFX;

    @FXML
    private TextField txtExcessMileageFX;

    @FXML
    private TextField txtPerDayCostFX;

    @FXML
    private TextField txtVehicleNBFX;

    @FXML
    private TextField txtVehicleNameFX;

    VehicleBO vehicleBO=(VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEHICLE);

    public static boolean isSavedDone=false;
    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(isValidated()){
            boolean isSaved=vehicleBO.save(new VehicleDTO(
                    txtVehicleNBFX.getText(),
                    cmbTypeFX.getValue(),
                    txtVehicleNameFX.getText(),
                    Double.parseDouble(txtPerDayCostFX.getText()),
                    Double.parseDouble(txtExcessMileageFX.getText()),
                    cmbStatusFX.getValue()
                    ));
            if(isSaved){
                isSavedDone=true;
                Navigation.closePopup();
            }
        }
    }

    public void initialize(){
        ObservableList<Integer> statusList= FXCollections.observableArrayList(1,0);
        ObservableList<String> typeList= FXCollections.observableArrayList("luxury","SUV","luxury van","MVP","normal");

        cmbStatusFX.setItems(statusList);
        cmbTypeFX.setItems(typeList);
    }
    @FXML
    void btnVehicleSaveExit(ActionEvent event) {
        Navigation.closePopup();
    }

    private boolean isValidated() {
        boolean isvehicleTypeValidated= cmbTypeFX.getValue()!=null;
        if(!isvehicleTypeValidated){
            cmbTypeFX.setStyle("-fx-text-fill: red;");
        }
        boolean isvehicleStatusValidated= cmbStatusFX.getValue()!=null;
        if(!isvehicleStatusValidated){
            cmbStatusFX.setStyle("-fx-text-fill: red;");
        }


        boolean isName=txtVehicleNameFX.getText().matches(".{6,}");
        if (!isName){
            txtVehicleNameFX.setStyle("-fx-text-fill: red;");

        }
        boolean isPerDayCost=txtPerDayCostFX.getText()!=null;
        if(!isPerDayCost){
            txtPerDayCostFX.setStyle("-fx-text-fill: red;");
        }
        boolean isExcessMilage=txtExcessMileageFX.getText()!=null;
        if(!isExcessMilage){
            txtExcessMileageFX.setStyle("-fx-text-fill: red;");
        }
        boolean isVehicleIDValidated=txtVehicleNBFX.getText().matches("[A-Z]{2,}-\\d{4}");
        if(!isVehicleIDValidated){
            txtVehicleNBFX.setStyle("-fx-text-fill: red;");
        }

        return isvehicleTypeValidated && isName && isPerDayCost && isExcessMilage && isVehicleIDValidated;

    }
}
