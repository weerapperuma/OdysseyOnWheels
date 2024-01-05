package lk.penguin.OdysseyOnWheels.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class BackgroundFormController implements Initializable {

    @FXML
    public AnchorPane pagingPane;
    @FXML
    private Label lblDateAndTime;
    public static int transfer=0;
    private static BackgroundFormController controller;
    public BackgroundFormController(){
        controller=this;
    }
    public static BackgroundFormController getInstance(){
        return controller;
    }
    public void startClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String currentDateTime = dateTimeFormat.format(new Date());
            lblDateAndTime.setText(currentDateTime);
        }));

        // Set the timeline to repeat indefinitely
        clockTimeline.setCycleCount(Timeline.INDEFINITE);

        // Start the timeline
        clockTimeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startClock();
        try {
            if(BackgroundFormController.transfer==1){
                goToRent();
                transfer=0;
            }else{
                goTOAdmin();
                transfer=0;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void goTOAdmin() throws IOException {
        Navigation.switchPaging(pagingPane,"dashBoard.fxml");
    }
    public void goToRent() throws IOException {
        Navigation.switchPaging(pagingPane,"rentalDashBoardForm.fxml");
    }
    @FXML
    void dashCloseButtonOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void navigateLoginButtonOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("welcomeForm.fxml",event);
    }
}
