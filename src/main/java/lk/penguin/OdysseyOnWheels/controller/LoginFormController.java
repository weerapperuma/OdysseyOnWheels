package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.custom.UserBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.UserBOImpl;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    @FXML
    private Button btnLoginfxId;

    UserBO userBO=new UserBOImpl();
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(userBO.checkCredentials(txtUserName.getText(),txtPassword.getText())){
            Navigation.closePopup();
            Navigation.closeCurrentWindow(event);
            Navigation.switchNavigation( "backgroundForm.fxml",event);

        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid Login Details");
        }

    }
    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("welcomeForm.fxml",event);
    }

    @FXML
    void hplinkTroubleLogin(ActionEvent event) {

    }
    public void initialize(){
        txtUserName.setOnAction(event ->txtPassword.requestFocus());
        txtPassword.setOnAction(event ->btnLoginfxId.fire());
    }
}
