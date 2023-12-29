package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;

public class CustomerManageFormController {

    @FXML
    private VBox mainContainer;

    @FXML
    private Pane managePane;

    @FXML
    private ScrollPane scrolePane;

    public VBox getMainContainer(){
        return mainContainer;
    }
    public void setMainContainer(VBox mainContainer){
        this.mainContainer=mainContainer;
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane,"dashBoard.fxml");
    }

    @FXML
    void saveCustomerOnAction(ActionEvent event) {

    }

    
}
