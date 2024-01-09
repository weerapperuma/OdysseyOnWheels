package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.OdysseyOnWheels.bo.BOFactory;
import lk.penguin.OdysseyOnWheels.bo.custom.EmployeeBO;
import lk.penguin.OdysseyOnWheels.bo.custom.impl.EmployeeBOImpl;
import lk.penguin.OdysseyOnWheels.dto.EmployeeDTO;
import lk.penguin.OdysseyOnWheels.util.Navigation;

import java.io.IOException;
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
    private TextField txtSearchFxId;

    EmployeeBO employeeBO= (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);
    @FXML
    void txtsearchOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(txtSearchFxId.getLength()==0){
            Navigation.switchPaging(AdminFormInterfaceController.getInstance().adminUseCasesLoadPane, "employeeManageForm.fxml");
        }
        else{
            ArrayList<EmployeeDTO>employeeDTOS=employeeBO.search(txtSearchFxId.getText());
            mainContainer.getChildren().clear();
            for(EmployeeDTO employeeDTO:employeeDTOS){
                createEmployeeRawLoadPane(employeeDTO);
            }
        }
    }

    @FXML
    void saveEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.popupPaging(AdminFormInterfaceController.getInstance().adminUseCasesLoadPane, "employeeSaveForm.fxml");
    }

    public void initialize() throws SQLException, ClassNotFoundException, IOException {

        ArrayList<EmployeeDTO> employeeDTOS=employeeBO.getAll();
        for(EmployeeDTO dto:employeeDTOS){
            createEmployeeRawLoadPane(dto);
        }

    }
    private void createEmployeeRawLoadPane(EmployeeDTO dto) throws IOException {
        FXMLLoader loader=new FXMLLoader(EmployeeManageFormController.class.getResource("/view/employeeRawForm.fxml"));
        Parent root=loader.load();
        EmployeeRawFormController controller=loader.getController();

        controller.setData(dto);

        mainContainer.getChildren().add(root);

    }


}
