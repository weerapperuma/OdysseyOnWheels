package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.bo.custom.LanguageBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.LanguageBOImpl;

import java.sql.SQLException;

public class RentalCustomerFormController {

    @FXML
    private JFXComboBox<?> cmbDropOffLocation;

    @FXML
    private JFXComboBox<?> cmbPickupLocation;

    @FXML
    private DatePicker datePickerEnding;

    @FXML
    private DatePicker datePickerStarting;
    @FXML
    private Label lblStartingDate;

    @FXML
    private Label lblEndingDate;


    @FXML
    private Label lblCustId;

    @FXML
    private Label lblCustIdSelected;

    @FXML
    private Label lblDropOffLocation;

    @FXML
    private Label lblPickUpLocation;

    @FXML
    private Label lblRentIdAutoGenerate;

    @FXML
    private Label lblRentalId;

    @FXML
    private JFXButton lblSearchButton;

    @FXML
    private Pane paneBokingfirstpane;

    @FXML
    private AnchorPane rentCustomerAnchorPane;
    @FXML
    private JFXComboBox<?> cmbLanguageFXID;

    LanguageBO languageBO=new LanguageBOImpl();
    @FXML
    void menuButtonOnAction(ActionEvent event) {

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {

    }
    @FXML
    void cmbLanguageChangeOnAction(ActionEvent event) {

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        setValues();
        ObservableList<String> languageList= languageBO.getLanguageList();


    }
    public void setValues() throws SQLException, ClassNotFoundException {
        lblRentalId.setText(languageBO.get(LanguageBOImpl.language,5));
        lblCustId.setText(languageBO.get(LanguageBOImpl.language,1));
        lblPickUpLocation.setText(languageBO.get(LanguageBOImpl.language,6));
        lblDropOffLocation.setText(languageBO.get(LanguageBOImpl.language,7));
        lblStartingDate.setText(languageBO.get(LanguageBOImpl.language,3));
        lblEndingDate.setText(languageBO.get(LanguageBOImpl.language,4));
    }

}
