package lk.penguin.OdysseyOnWheels.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddedCartFormController {

    @FXML
    private Label addedCartCarID;

    @FXML
    void btnAddedCarDeleteOnAction(ActionEvent event) {

    }

    public void setData(String text) {
        System.out.println(text);
        addedCartCarID.setText("hello");
        System.out.println("added successfully"+text);
    }
}
