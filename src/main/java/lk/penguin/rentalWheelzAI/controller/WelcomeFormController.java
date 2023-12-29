package lk.penguin.rentalWheelzAI.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeFormController implements Initializable {

    @FXML
    private Pane weclcomeNicFxId;

//    private static WelcomeFormController controller;
//
//    public WelcomeFormController(){
//        controller=this;
//    }
//    public static WelcomeFormController getInstance(){
//        return controller;
//    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void AdminLoginOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("loginForm.fxml",event);
    }

    @FXML
    void changeToFrenchNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicFranceForm.fxml");
    }

    @FXML
    void changeToGermanNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicGermanForm.fxml");
    }

    @FXML
    void changeToHindiNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicHindiForm.fxml");
    }

    @FXML
    void changeToRussianNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicRussianForm.fxml");
    }

    @FXML
    void changeToSinhalaNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicSinhalaForm.fxml");
    }
    @FXML
    void changeToEnglishNIC(ActionEvent event) throws IOException {
        Navigation.switchPaging(weclcomeNicFxId,"nicEnglishForm.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Navigation.switchPaging(weclcomeNicFxId,"nicEnglishForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
