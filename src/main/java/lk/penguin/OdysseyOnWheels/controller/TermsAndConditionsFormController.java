package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import lk.penguin.OdysseyOnWheels.util.LanguageUtil;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class TermsAndConditionsFormController {

    @FXML
    private JFXTextArea textAreaTermsAndConditions;

    public void initialize() throws SQLException, ClassNotFoundException {
        textAreaTermsAndConditions.setText(LanguageUtil.get(LanguageUtil.language,8));
    }

}
