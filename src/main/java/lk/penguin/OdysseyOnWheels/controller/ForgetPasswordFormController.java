package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.ForgetPasswordBO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import javax.mail.MessagingException;
import java.sql.SQLException;

public class ForgetPasswordFormController {

    @FXML
    private JFXButton btnCloseForgotForm;

    @FXML
    private PasswordField confirmPasswordFx;

    @FXML
    private Label lblOtpFx;

    @FXML
    private PasswordField newPasswordFx;

    @FXML
    private TextField txtOtpFx;

    ForgetPasswordBO forgetPasswordBO=(ForgetPasswordBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.FORGET);
    public static String newOtp=null;
    @FXML
    void ResetPasswordOnAction(ActionEvent event) throws SQLException, MessagingException, ClassNotFoundException {
        newPasswordFx.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        confirmPasswordFx.setStyle("-fx-text-fill: #000000; -fx-font-weight: bold; -fx-font-size: 14;");
        btnCloseForgotForm.setText("*");
        if(newPasswordFx.getText().equals(confirmPasswordFx.getText())){
            newOtp=forgetPasswordBO.getOTP();
            txtOtpFx.setVisible(true);
            lblOtpFx.setVisible(true);
        }
        else{
            newPasswordFx.setStyle("-fx-text-fill: red;");
            confirmPasswordFx.setStyle("-fx-text-fill: red;");
            btnCloseForgotForm.setText("Password doesn not match");
        }
    }

    @FXML
    void btnCloseForgotFormOnAction(ActionEvent event) {
        Navigation.closePopup();
    }

    @FXML
    void txtOtpOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(newOtp.equals(txtOtpFx.getText())){
            boolean updated=forgetPasswordBO.update(WelcomeFormController.passportId,newPasswordFx.getText());

            System.out.println("DAO;"+updated);
            if(updated){
                System.out.println("set unaaaaaa");
                Navigation.closePopup();
            }
        }
    }
    public void initialize(){
        lblOtpFx.setVisible(false);
        txtOtpFx.setVisible(false);
    }

}
