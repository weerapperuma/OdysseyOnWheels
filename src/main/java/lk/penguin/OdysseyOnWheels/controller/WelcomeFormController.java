package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.bo.custom.LanguageBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.LanguageBOImpl;
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

    LanguageBO languageBO=new LanguageBOImpl();

    public static String language="english";


    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {
        if(txtPassportId.getLength()>9){
            System.out.println(txtPassportId.getLength());
            BackgroundFormController.transfer=1;
            Navigation.switchNavigation( "backgroundForm.fxml",event);
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
    void changeToFrenchNIC(ActionEvent event) throws IOException {
        lblTitle.setText("numéro de passeport");
        btntxtRent.setText("Faire un loyer");
    }

    @FXML
    void changeToGermanNIC(ActionEvent event) throws IOException {
        lblTitle.setText("Nummer des Reisepasses");
        btntxtRent.setText("Miete machen");
    }

    @FXML
    void changeToHindiNIC(ActionEvent event) throws IOException {
        lblTitle.setText("पासपोर्ट नंबर");
        btntxtRent.setText("किराया लगाओ");
    }

    @FXML
    void changeToRussianNIC(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        this.language="russian";
        setValues();
    }

    @FXML
    void changeToSinhalaNIC(ActionEvent event) throws IOException {
        lblTitle.setText("ජාතික හැඳුනුම්පත් අංකය");
        btntxtRent.setText("කුලියට ගන්න");
    }
    @FXML
    void changeToEnglishNIC(ActionEvent event) throws IOException {
        lblTitle.setText("ID / Passport");
        btntxtRent.setText("Make a Rent");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            lblTitle.setText(languageBO.get(language,1));
            btntxtRent.setText(languageBO.get(language,2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void setValues() throws SQLException, ClassNotFoundException {
        lblTitle.setText(languageBO.get(language,1));
        btntxtRent.setText(languageBO.get(language,2));
    }
}
