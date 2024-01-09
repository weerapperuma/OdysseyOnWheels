package lk.penguin.OdysseyOnWheels.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminFormInterfaceController implements Initializable {

    @FXML
    public Pane adminUseCasesLoadPane;

    @FXML
    private Label lblDateTimeSet;
    private static AdminFormInterfaceController adminFormInterfaceController;
    public AdminFormInterfaceController(){
        adminFormInterfaceController=this;
    }
    public static AdminFormInterfaceController getInstance(){
        return adminFormInterfaceController;
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(adminUseCasesLoadPane, "customerManageForm.fxml");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {

    }



    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("adminFormInterface.fxml",event);
    }

    @FXML
    void btnRentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnVehicleOnAction(ActionEvent event) {

    }

    @FXML
    void closeAppOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnExitOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("welcomeForm.fxml",event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startClock();

    }

    private void startClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDateTime = dateTimeFormat.format(new Date());
            lblDateTimeSet.setText(currentDateTime);
        }));

        // Set the timeline to repeat indefinitely
        clockTimeline.setCycleCount(Timeline.INDEFINITE);

        // Start the timeline
        clockTimeline.play();
    }
}
