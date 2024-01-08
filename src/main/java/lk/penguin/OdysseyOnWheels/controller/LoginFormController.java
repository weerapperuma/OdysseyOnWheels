
package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class LoginFormController {

    @FXML
    private JFXButton btnpassworduser;

    @FXML
    private PasswordField txtPasswordUser;

    @FXML
    void btnUserPasswordOnAction(ActionEvent event) {

    }

    public void initialize(){
        txtPasswordUser.setOnAction(event ->btnpassworduser.requestFocus());
    }
}
