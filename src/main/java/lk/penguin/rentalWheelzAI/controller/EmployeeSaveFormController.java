package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;
import lk.penguin.rentalWheelzAI.dto.EmployeeDTO;
import lk.penguin.rentalWheelzAI.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeSaveFormController {
    EmployeeManageFormController employeeManageFormController=new EmployeeManageFormController();
    EmployeeBO employeeBO=new EmployeeBOImpl(employeeManageFormController);

    @FXML
    private Label lblEmpId;

    @FXML
    private TextField txtEmpAddress;

    @FXML
    private TextField txtEmpContact;

    @FXML
    private TextField txtEmpEmail;

    @FXML
    private TextField txtEmpINic;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtEmpPosition;
    String empID="";

//    public void EmployeeSaveFormController(){
//        this.txtEmpName=txtEmpName;
//    }
    public void initialize() throws SQLException, ClassNotFoundException {
        empID=generateId();
        this.lblEmpId.setText(empID);

    }

    private String generateId() throws SQLException, ClassNotFoundException {
        String lastId=employeeBO.generateNewId();
        if(lastId!=null){
            String lastNumber=trimFirstLetter(lastId);
            int newLastNumber=Integer.parseInt(lastNumber)+1;
            String out=String.format("E%03d",newLastNumber);
            return out;
        }
        else {
            return "E001";
        }
    }
    public static String trimFirstLetter(String input){
        return input.substring(1);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEmployeeId(empID);
        employeeDTO.setEmployeeName(txtEmpName.getText());
        employeeDTO.setEmpEmail(txtEmpEmail.getText());
        employeeDTO.setEmpNIC(txtEmpINic.getText());
        employeeDTO.setEmpPosition(txtEmpPosition.getText());
        employeeDTO.setEmpAddress(txtEmpAddress.getText());
        employeeDTO.setEmpContact(txtEmpContact.getText());

        boolean isSaved=employeeBO.save(employeeDTO);
        if(isSaved){
            Navigation.switchPaging(BackgroundFormController.getInstance().pagingPane, "employeeManageForm.fxml");
            Navigation.closePopup();
        }
    }

}
