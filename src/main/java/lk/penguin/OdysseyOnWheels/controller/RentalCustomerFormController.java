package lk.penguin.OdysseyOnWheels.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.bo.custom.RentBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.RentBOImpl;
import lk.penguin.OdysseyOnWheels.dto.RentDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    @FXML
    private Pane transactionLoadPane;
    @FXML
    private Pane paneWhyChosseUs;
    @FXML
    public  Pane tableLoadPane;
    private static RentalCustomerFormController controller;
    public RentalCustomerFormController(){
        controller=this;
    }
    public static RentalCustomerFormController getInstance(){
        return controller;
    }
    public static String startingDay;
    public static String endingDay;

    RentBO rentBO=new RentBOImpl();
    @FXML
    void menuButtonOnAction(ActionEvent event) {

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) throws IOException, SQLException {
        LocalDate sDate =datePickerStarting.getValue();
        if(sDate!=null){
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            startingDay=sDate.format(formatter);
            LocalDate eDate=datePickerEnding.getValue();
            if(eDate!=null){
                endingDay=eDate.format(formatter);
                TransactionUtil.startTransaction();
                rentBO.save(new RentDTO(lblRentalId.getText(),
                        lblCustId.getText(),
                        0.0,0.0,0.0,
                        datePickerStarting.getValue(),
                        datePickerStarting.getValue(),
                        LocalDate.now()));
                Navigation.switchPaging(tableLoadPane,"transactionForm.fxml");
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Invalid date");
        }


    }
    @FXML
    void cmbLanguageChangeOnAction(ActionEvent event) throws IOException {
        WelcomeFormController.language=(String) cmbLanguageFXID.getValue();
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "rentalCustomerForm.fxml");
    }
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        setLabelValues();
        setComboboxValues();
        datePickerEnding.setOnAction(event ->lblSearchButton.fire());

        Navigation.switchPaging(RentalCustomerFormController.getInstance().paneWhyChosseUs,"whyChooseUsForm.fxml");
    }

    private void setComboboxValues() throws SQLException, ClassNotFoundException {
        ObservableList languageList= rentBO.getLanguageList();
        cmbLanguageFXID.setItems(languageList);

        ObservableList locations=rentBO.getLocations();
        cmbPickupLocation.setItems(locations);
        cmbDropOffLocation.setItems(locations);
        lblCustIdSelected.setText(WelcomeFormController.passportId);
        lblRentIdAutoGenerate.setText(rentBO.generateId());
    }

    public void setLabelValues() throws SQLException, ClassNotFoundException {


        lblRentalId.setText(rentBO.get(WelcomeFormController.language,5));
        lblCustId.setText(rentBO.get(WelcomeFormController.language,1));
        lblPickUpLocation.setText(rentBO.get(WelcomeFormController.language,6));
        lblDropOffLocation.setText(rentBO.get(WelcomeFormController.language,7));
        lblStartingDate.setText(rentBO.get(WelcomeFormController.language,3));
        lblEndingDate.setText(rentBO.get(WelcomeFormController.language,4));
    }
}
