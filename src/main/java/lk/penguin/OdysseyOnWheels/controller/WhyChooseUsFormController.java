package lk.penguin.OdysseyOnWheels.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.OdysseyOnWheels.util.LanguageUtil;

import java.sql.SQLException;

public class WhyChooseUsFormController {

    @FXML
    private Label lblBookingAmendants;

    @FXML
    private Label lblEasyAndSecure;

    @FXML
    private Label lblModernFleet;

    @FXML
    private Label lblReasonsWhy;

    @FXML
    private Label lblUnlimitedMileage;

    @FXML
    private Label lblWhyChooseUs;

    @FXML
    private Label lblcustomerSupport;

    public void initialize() throws SQLException, ClassNotFoundException {
        lblWhyChooseUs.setText(LanguageUtil.get(LanguageUtil.language,9));
        lblReasonsWhy.setText(LanguageUtil.get(LanguageUtil.language,10));
        lblEasyAndSecure.setText(LanguageUtil.get(LanguageUtil.language,11));
        lblBookingAmendants.setText(LanguageUtil.get(LanguageUtil.language,12));
        lblcustomerSupport.setText(LanguageUtil.get(LanguageUtil.language,13));
        lblModernFleet.setText(LanguageUtil.get(LanguageUtil.language,14));
        lblUnlimitedMileage.setText(LanguageUtil.get(LanguageUtil.language,15));
    }
}
