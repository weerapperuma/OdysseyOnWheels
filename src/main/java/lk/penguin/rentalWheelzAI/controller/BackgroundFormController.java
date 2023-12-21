package lk.penguin.rentalWheelzAI.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.penguin.rentalWheelzAI.util.Navigation;

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
    private static BackgroundFormController controller;

    public BackgroundFormController(){
        controller=this;
    }
    public static BackgroundFormController getInstance(){
        return controller;
    }
    public void startClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            // Update time label
            //SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
            //String currentTime = timeFormat.format(new Date());
            //lblDateShow.setText(currentTime);

            // Update date-time label
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
            Navigation.switchPaging(pagingPane,"loginForm.fxml");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
