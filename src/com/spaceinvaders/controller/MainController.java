package com.spaceinvaders.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

import com.spaceinvaders.utils.Constants;

import java.io.File;

public class MainController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label nameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setFont(Constants.FONT_MONO);
    }

    public void openGame(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvaders/view/Game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
