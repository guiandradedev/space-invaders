package com.spaceinvasors.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
 
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvasors/view/Main.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("Space Invasors");
            Image icon = new Image(getClass().getResourceAsStream("/com/spaceinvasors/image/icon.png"));
            stage.getIcons().add(icon); // seta o icone do app

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}
