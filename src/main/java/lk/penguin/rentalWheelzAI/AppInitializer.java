package lk.penguin.rentalWheelzAI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader.load(this.getClass().getResource("/view/welcomeForm.fxml"));

        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/welcomeForm.fxml")));
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Get your Travel Quickly");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}
