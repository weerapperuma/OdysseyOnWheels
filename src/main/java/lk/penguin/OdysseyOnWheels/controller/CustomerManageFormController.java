package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.custom.CustomerBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.CustomerBOImpl;
import lk.penguin.OdysseyOnWheels.dto.CustomerDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    void saveCustomerOnAction(ActionEvent event) throws IOException {
        Navigation.popupPaging(BackgroundFormController.getInstance().pagingPane, "customerSaveForm.fxml");

    }
    public void initialize() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<CustomerDTO> dtos=customerBO.loadTableView();

        for (CustomerDTO customerDTO1:dtos){
            createCustomerRawLoadPane(customerDTO1);
        }
    }

    private void createCustomerRawLoadPane(CustomerDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(CustomerManageFormController.class.getResource("/view/customerRawForm.fxml"));
        Parent root=loader.load();
        CustomerRawFormController controller=loader.getController();

        controller.setData(dto);

        this.getMainContainer().getChildren().add(root);
    }


}
