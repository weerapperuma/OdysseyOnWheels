package lk.penguin.rentalWheelzAI.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
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

    EmployeeBO employeeBO= new EmployeeBOImpl(this);
    public VBox getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(VBox mainContainer) {
        this.mainContainer = mainContainer;
    }



    public void initialize() throws SQLException, ClassNotFoundException, IOException {

        employeeBO.loadTableView();

    }


}
