package com.spaceinvasors.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.spaceinvasors.model.Player;
import com.spaceinvasors.model.Position;
import com.spaceinvasors.components.PlayerArt;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.List;

public class GameController implements Initializable {
    private Stage stage;
    private Scene scene;

    // private List<>

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);

        // for(int i=0; i<4; i++) {
        //     for(int i=0; i<10; i++) {

        //     }
        // } 

        Player player = new Player(new Position(100, 400), 0, 0, 0, 0);
        PlayerArt playerArt = new PlayerArt(10, 10, 10,player); 

        root.getChildren().add(playerArt);

        root.setOnKeyPressed(event -> {
            event.consume(); 
            if (event.getCode() == KeyCode.A) {
                playerArt.move(-8, 0);
            } else if(event.getCode() == KeyCode.D) {
                playerArt.move(8, 0);
                playerArt.setLayoutX(player.getPosition().getX());
            }
        });


        root.requestFocus();
    }

    public void backMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvasors/view/Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
