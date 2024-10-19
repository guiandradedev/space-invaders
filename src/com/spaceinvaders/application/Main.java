package com.spaceinvaders.application;

import com.spaceinvaders.utils.Constants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class Main extends Application {
    @Override
        public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvaders/view/Main.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle(Constants.GAME_TITLE);
            Image icon = new Image(getClass().getResourceAsStream("/com/spaceinvaders/image/icon.png"));
            stage.getIcons().add(icon);

            stage.setResizable(false);
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
