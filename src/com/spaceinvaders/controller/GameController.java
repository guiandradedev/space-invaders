package com.spaceinvaders.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.spaceinvaders.components.HearthArt;
import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.components.StrongInvasor;
import com.spaceinvaders.enums.InvasorType;
import com.spaceinvaders.model.Invasor;
import com.spaceinvaders.model.Player;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Label hitsLabel;
    @FXML
    private Label pointsLabel;

    // Variaveis
    private final int totalX = Constants.SCREEN_WIDTH - 2*Constants.LIMIT_SCREEN_WIDTH;
    private final int totalY = Constants.SCREEN_HEIGHT - 2*Constants.LIMIT_SCREEN_HEIGHT;
    private int level = 1;
    private int initialSpeed = 0;
    private int bullet_speed = 10;

    // Personagens
    private Player player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);
    
        createPlayer();
        generateInvasors(0);
    
        Platform.runLater(() -> root.requestFocus());
        root.setOnKeyPressed(this::keyChange);

        root.requestFocus();
    }
    

    public void generateInvasors(int baseSpeed) {
        int baseHeight = 150;
        for (InvasorType type : InvasorType.values()) {
            for(int i=0; i<11; i++) {
                createInvasor(type, i, baseHeight, baseSpeed);
            }
            baseHeight += 100;
        }
    }

    private void createInvasor(InvasorType invasorType, int positionX, int baseHeight, int speed) {
        InvasorComponent invasorArt = invasorType.createInvasorArt(invasorType.getWidth(), invasorType.getHeight(), 3);
        Invasor invasor = new Invasor(new Position((positionX * 50) + Constants.LIMIT_SCREEN_WIDTH, baseHeight), 1, invasorType.getSpeed() + speed, invasorType, invasorArt);
        invasor.print(root);
    }

    private void createPlayer() {
        PlayerArt playerArt = new PlayerArt(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, 3); 
        player = new Player(new Position(Constants.LIMIT_SCREEN_WIDTH + 20, totalY + Constants.LIMIT_SCREEN_HEIGHT - playerArt.getHeight() - 50), 3, 7, 0, 0, playerArt);
        player.print(root);

        
        for(int i=0; i<player.getLives(); i++) {
            HearthArt hearthArt = new HearthArt(10, 8, 3);
            hearthArt.print(new Position((i*hearthArt.getWidth()*1.4) + Constants.LIMIT_SCREEN_WIDTH, Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT - 20), root);
        }
    }

    private void keyChange(KeyEvent event){
        System.out.println("ads");
        event.consume();
        switch (event.getCode()) {
            case RIGHT:
                player.getElementArt().move(player, player.getSpeedX(),0);
                break;

            case LEFT:
                player.getElementArt().move(player, -player.getSpeedX(),0);
                break;
                
            case ENTER:
                this.shoot();
                break;           
            default:
                break;
        }
    }    

    private void shoot() {

    }
}
