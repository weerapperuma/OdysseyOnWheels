package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.bo.UserBO;
import lk.penguin.rentalWheelzAI.bo.UserBOImpl;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO=new UserBOImpl();
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(userBO.checkCredentials(txtUserName.getText(),txtPassword.getText())){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "dashBoard.fxml");
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Login Details");
        }

    }

    @FXML
    void hplinkTroubleLogin(ActionEvent event) {

    }
}
