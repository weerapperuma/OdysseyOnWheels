package lk.penguin.rentalWheelzAI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.penguin.rentalWheelzAI.bo.EmployeeBO;
import lk.penguin.rentalWheelzAI.bo.EmployeeBOImpl;

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
    public void initialize() throws SQLException, ClassNotFoundException {
        this.lblEmpId.setText(generateId());

    }

    private String generateId() throws SQLException, ClassNotFoundException {
        String lastId=employeeBO.generateNewId();
        if(lastId!=null){
            String lastNumber=trimFirstLetter(lastId);
            int newLastNumber=Integer.parseInt(lastNumber)+1;
            System.out.println("alut eka "+newLastNumber);
            String out=String.format("E%03d",newLastNumber);
            System.out.println(out);
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
    void btnSaveOnAction(ActionEvent event) {

    }

}
