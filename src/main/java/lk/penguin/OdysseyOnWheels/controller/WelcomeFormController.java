package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.UserBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.bo.custom.WelcomeBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.WelcomeBoImpl;
import lk.penguin.OdysseyOnWheels.util.LanguageUtil;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WelcomeFormController implements Initializable {

    @FXML
    private Pane weclcomeNicFxId;
    @FXML
    private Hyperlink hyperLinkForget;

    @FXML
    private Label lblTitle;
    @FXML
    private JFXButton btntxtRent;
    @FXML
    private TextField txtPassportId;

    @FXML
    private PasswordField pwPasswordField;



    public static String passportId="0";
    WelcomeBO welcomeBO=(WelcomeBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.WELCOME);
    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(welcomeBO.ifExistsCustomer(txtPassportId.getText())){
            this.passportId=txtPassportId.getText();
            Navigation.switchNavigation( "backgroundForm.fxml",event);

        }
        if(welcomeBO.ifExistsUser(txtPassportId.getText())){
            String tempUserName=txtPassportId.getText();
            pwPasswordField.setVisible(true);

            pwPasswordField.setOnKeyReleased(keyEvent -> {
                try {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        boolean isTrue = welcomeBO.chekCredentials(tempUserName, pwPasswordField.getText());
                        if (isTrue) {
                            Navigation.switchNavigation( "adminFormInterface.fxml",event);
                        }else{
                            hyperLinkForget.setVisible(true);
                        }
                    }
                } catch (IOException | SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
        else {
            //Navigation.popupPaging(weclcomeNicFxId,"customerSaveForm.fxml" );
        }

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void forgetPasswordOnAction(ActionEvent event) throws IOException {
        passportId=txtPassportId.getText();
        Navigation.popupPaging(weclcomeNicFxId,"forgetPasswordForm.fxml");
    }
    @FXML
    void changeToFrenchNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="french";
        setValues();
    }

    @FXML
    void changeToGermanNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="german";
        setValues();
    }

    @FXML
    void changeToHindiNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="hindi";
        setValues();
    }

    @FXML
    void changeToRussianNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="russian";
        setValues();
    }

    @FXML
    void changeToSinhalaNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="sinhala";
        setValues();
    }
    @FXML
    void changeToEnglishNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        LanguageUtil.language="english";
        setValues();
    }

    @FXML
    void changeToTamilNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        LanguageUtil.language="tamil";
        setValues();
    }
    @FXML
    void changeToChineseNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        LanguageUtil.language="chinese";
        setValues();
    }
    @FXML
    void changeToJapaneseNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        LanguageUtil.language="japan";
        setValues();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pwPasswordField.setVisible(false);
        hyperLinkForget.setVisible(false);
        txtPassportId.setOnAction(event -> btntxtRent.fire());

        try {
            setValues();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void setValues() throws SQLException, ClassNotFoundException {
        lblTitle.setText(LanguageUtil.get(LanguageUtil.language,1));
    }

}
