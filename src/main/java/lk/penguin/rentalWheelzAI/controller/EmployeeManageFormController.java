package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.Navigation;
import lk.penguin.rentalWheelzAI.util.SQLUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeManageFormController {
    @FXML
    private VBox mainContainer;
    @FXML
    private Pane managePane;
    @FXML
    private ScrollPane scrolePane;
    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "dashBoard.fxml");
    }

    EmployeeBO employeeBO= new EmployeeBOImpl(this);
    public VBox getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(VBox mainContainer) {
        this.mainContainer = mainContainer;
    }


    @FXML
    void saveEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.popupPaging(BackgroundFormController.getInstance().pagingPane,"employeeSaveForm.fxml");
    }

    public void initialize() throws SQLException, ClassNotFoundException, IOException {

        employeeBO.loadTableView();

    }


}
