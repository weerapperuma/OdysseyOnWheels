package lk.penguin.rentalWheelzAI.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Navigation {
    private static Parent rootNode;
    private static Scene scene;
    private static Stage stage;

    public static void switchNavigation(String path, ActionEvent event) throws IOException {
        rootNode= FXMLLoader.load(Navigation.class.getResource("/view/"+path));

        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();

        scene =new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(Navigation.class.getResource("/view/"+path));

        Parent root=loader.load();
        pane.getChildren().add(root);
    }

    public static void popupPaging(Pane pane,String path) throws IOException {
        FXMLLoader loader=new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root=loader.load();

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(pane.getScene().getWindow());

        popupStage.setTitle("Update");

        Scene scene1=new Scene(root);
        popupStage.setScene(scene1);

        popupStage.centerOnScreen();

        popupStage.showAndWait();
    }

}
