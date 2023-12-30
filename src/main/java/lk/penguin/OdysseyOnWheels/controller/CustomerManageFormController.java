package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerManageFormController {

    @FXML
    private VBox mainContainer;

    @FXML
    private Pane managePane;

    @FXML
    private ScrollPane scrolePane;

    CustomerBO customerBO=new CustomerBOImpl();
    CustomerDTO customerDTO=new CustomerDTO();

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
    public void initialize() throws SQLException, ClassNotFoundException {
        customerBO.loadTableView(customerDTO);
    }


}
