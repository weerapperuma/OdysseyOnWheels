package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;

public class RentalDashBoardFormController {

    private static RentalDashBoardFormController controller;

    public RentalDashBoardFormController(){
        controller=this;
    }
    public static RentalDashBoardFormController getInstance(){
        return controller;
    }

    @FXML
    private AnchorPane rentalDashBoardAnchorPane;

    @FXML
    private AnchorPane rentalDashBoardPane;

    @FXML
    private ScrollPane rentalDashBoardScroll;

    public void initialize() throws IOException {

        Navigation.switchPaging(RentalDashBoardFormController.controller.rentalDashBoardPane, "rentalCustomerForm.fxml");
    }

}
