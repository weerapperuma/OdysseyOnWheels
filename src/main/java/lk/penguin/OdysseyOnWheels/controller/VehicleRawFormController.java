package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VehicleRawFormController {

    @FXML
    private JFXComboBox<Integer> cmbAvailableFx;

    @FXML
    private Label lblVehicleIDFx;

    @FXML
    private TextField txtAccessMileage;

    @FXML
    private TextField txtPerDayCostFx;

    @FXML
    private TextField txtTypeFx;

    @FXML
    private TextField txtVehicleNameFx;

    VehicleBO vehicleBO=(VehicleBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.VEHICLE);

    @FXML
    void deleteOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(vehicleBO.delete(lblVehicleIDFx.getText())){
            System.out.println("done");
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        setCustomEditable(true);
    }

    public void setData(VehicleDTO dto) {
        lblVehicleIDFx.setText(dto.getVehicleId());
        txtTypeFx.setText(dto.getVehicleType());
        txtVehicleNameFx.setText(dto.getVehicleName());
        txtPerDayCostFx.setText(Double.toString(dto.getPerDay80Km()));
        txtAccessMileage.setText(Double.toString(dto.getExcessMileage()));

        ObservableList<Integer> statusList= FXCollections.observableArrayList(1,0);
        cmbAvailableFx.setItems(statusList);

        if(statusList.contains(dto.getStatus())){
            cmbAvailableFx.setValue(dto.getStatus());
        }else {
            System.out.println("Not in list");
        }
    }
    @FXML
    void cmbStatusOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        setForUpdate();

    }

    private boolean isValidated() {
        boolean isvehicleTypeValidated= Set.of("luxury","SUV","luxury van","MVP","normal").contains(txtTypeFx.getText());
        if(!isvehicleTypeValidated){
            txtTypeFx.setStyle("-fx-text-fill: red;");
        }

        boolean isName=txtVehicleNameFx.getText().matches(".{6,}");
        if (!isName){
            txtVehicleNameFx.setStyle("-fx-text-fill: red;");

        }
        boolean isPerDayCost=txtPerDayCostFx.getText()!=null;
        if(!isPerDayCost){
            txtPerDayCostFx.setStyle("-fx-text-fill: red;");
        }
        boolean isExcessMilage=txtAccessMileage.getText()!=null;
        if(!isExcessMilage){
            txtAccessMileage.setStyle("-fx-text-fill: red;");
        }
        return isvehicleTypeValidated && isName && isPerDayCost && isExcessMilage;

    }

    public void initialize(){
        setCustomEditable(false);
    }
    public void setCustomEditable(boolean x){
        txtVehicleNameFx.setEditable(x);
        txtTypeFx.setEditable(x);
        txtPerDayCostFx.setEditable(x);
        txtAccessMileage.setEditable(x);
    }
    private boolean update() throws SQLException, ClassNotFoundException {
        String prc=txtPerDayCostFx.getText();
        return vehicleBO.update(new VehicleDTO(
                lblVehicleIDFx.getText(),
                txtTypeFx.getText(),
                txtVehicleNameFx.getText(),
                Double.parseDouble(prc),
                Double.parseDouble(txtAccessMileage.getText()),
                cmbAvailableFx.getValue()));
    }
    private void setForUpdate() throws SQLException, ClassNotFoundException {
        txtTypeFx.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        txtVehicleNameFx.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        txtPerDayCostFx.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        txtAccessMileage.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        if(isValidated()){
            update();
        }
        setCustomEditable(false);
    }
    @FXML
    void txtExcessMileageOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        setForUpdate();
    }

    @FXML
    void txtPerDayCostOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        setForUpdate();
    }

    @FXML
    void txtVehicleNameOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        setForUpdate();
    }

    @FXML
    void txtVehicleTypeOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        setForUpdate();
    }
}
