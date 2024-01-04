package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.UserBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.UserBOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.WelcomeBO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.WelcomeBoImpl;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WelcomeFormController implements Initializable {

    @FXML
    private Pane weclcomeNicFxId;

    @FXML
    private Label lblTitle;
    @FXML
    private JFXButton btntxtRent;


    @FXML
    private TextField txtPassportId;


    public static String language="english";
    WelcomeBO welcomeBO=new WelcomeBoImpl();

    public static String passportId="0";
    CustomerBO customerBO=new CustomerBOImpl();

    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(customerBO.ifExists(txtPassportId.getText())){
            this.passportId=txtPassportId.getText();
            BackgroundFormController.transfer=1;
            Navigation.switchNavigation( "backgroundForm.fxml",event);
        }
        else {
            Navigation.popupPaging(BackgroundFormController.getInstance().pagingPane,"customerSaveForm.fxml" );
        }

    }
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
    void changeToFrenchNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="french";
        setValues();
    }

    @FXML
    void changeToGermanNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="german";
        setValues();
    }

    @FXML
    void changeToHindiNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="hindi";
        setValues();
    }

    @FXML
    void changeToRussianNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="russian";
        setValues();
    }

    @FXML
    void changeToSinhalaNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="sinhala";
        setValues();
    }
    @FXML
    void changeToEnglishNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        WelcomeFormController.language="english";
        setValues();
    }

    @FXML
    void changeToTamilNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        WelcomeFormController.language="tamil";
        setValues();
    }
    @FXML
    void changeToChineseNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        WelcomeFormController.language="chinese";
        setValues();
    }
    @FXML
    void changeToJapaneseNIC(ActionEvent event) throws SQLException, ClassNotFoundException {
        WelcomeFormController.language="japan";
        setValues();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        lblTitle.setText(welcomeBO.get(WelcomeFormController.language,1));
        btntxtRent.setText(welcomeBO.get(WelcomeFormController.language,2));
    }

}
