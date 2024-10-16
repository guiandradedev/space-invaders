package com.spaceinvasors.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void openGame(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvasors/view/Game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void openRules(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvasors/view/Rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
