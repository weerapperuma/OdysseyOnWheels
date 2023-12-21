package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "dashBoard.fxml");
    }

    @FXML
    void hplinkTroubleLogin(ActionEvent event) {

    }
}
