package com.spaceinvaders.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;

public class MainController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // File fontFile = new File("src/com/spaceinvaders/assets/fonts/PixeloidMono.ttf");

        // System.out.println(fontFile.exists());
        // System.out.println("aaa");

        // Font font = Font.loadFont(fontFile.toURI().toString(), 20);

        // Font font = Font.loadFont(getClass().getResourceAsStream("PixeloidMono.ttf"), 20);
        // System.out.println(font);
    }

    public void openGame(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvaders/view/Game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
