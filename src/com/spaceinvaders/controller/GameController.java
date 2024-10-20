package com.spaceinvaders.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.spaceinvaders.components.BulletArt;
import com.spaceinvaders.components.HearthArt;
import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.enums.InvasorType;
import com.spaceinvaders.model.Bullet;
import com.spaceinvaders.model.Invasor;
import com.spaceinvaders.model.Player;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class GameController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Label hitsLabel;
    @FXML
    private Label pointsLabel;

    // Constantes
    private final int totalX = Constants.SCREEN_WIDTH - 2*Constants.LIMIT_SCREEN_WIDTH;
    private final int totalY = Constants.SCREEN_HEIGHT - 2*Constants.LIMIT_SCREEN_HEIGHT;
    private final int initialHeight = Constants.LIMIT_SCREEN_HEIGHT + 100;
    private final int endHeight = totalY + Constants.LIMIT_SCREEN_HEIGHT - (Constants.PLAYER_HEIGHT * Constants.PIXEL_SIZE) - 50 - (Constants.BARRIER_HEIGHT * Constants.PIXEL_SIZE);
    private final int delay = 500; // em ms
    private final int totalEnemiesInLine = 11;
    private int totalEnemies = 0;

    // Variaveis
    private int level = 1;
    private int bullet_speed = 20;
    private short direction = 1; // true para direita, false para a esquerda 
    private boolean inGame = true;

    private Timeline timeline;

    // Personagens
    private Player player;
    private List<List<Invasor>> invasors = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);
    
        createPlayer();
        generateInvasors(0);

        animation();
    
        Platform.runLater(() -> root.requestFocus());
        root.setOnKeyPressed(this::keyChange);

        root.requestFocus();
    }
    

    public void generateInvasors(int baseSpeed) {
        int baseHeight = initialHeight;
        List<Invasor> aux;
        totalEnemies = 0;
        for (InvasorType type : InvasorType.values()) {
            aux = new ArrayList<>();
            for(int i=0; i<type.getLines(); i++) {
                for(int j=0; j<totalEnemiesInLine; j++) {
                    Invasor invasor = createInvasor(type, j, baseHeight, baseSpeed);
                    aux.add(invasor);
                }
                totalEnemies += totalEnemiesInLine;
                baseHeight += (2*Constants.INVASOR_HEIGHT) + 30;
            }
            invasors.add(aux);
        }
    }

    private void animation() {
        timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> moveAliens(invasors)));
        timeline.setCycleCount(Timeline.INDEFINITE); // Executa indefinidamente
        timeline.play(); // Inicia o movimento
    }
    
    private void endGame(boolean won) {
        if (timeline != null) {
            timeline.stop();
        }
    
        String info = won ? "Ganhou" : "Perdeu";
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação Importante");
            alert.setHeaderText("Voce " + info + "!");
            // alert.setContentText("um bosta");
            alert.showAndWait();
        });
    }
    

    private void moveAliens(List<List<Invasor>> invasors){
        boolean reachedEdge = false;
        boolean reachedHeight = false;
        for(List<Invasor> line : invasors){
            
            for (Invasor invasor : line) {
                if(invasor.isAlive()){
                    if((direction == 1) && (invasor.getPosition().getX() + Constants.INVASOR_WIDTH >= totalX)){
                        reachedEdge = true;
                        break;
                    }else if((direction == -1) && (invasor.getPosition().getX() <= Constants.LIMIT_SCREEN_WIDTH)) {
                        reachedEdge = true;
                        break;
                    }
                    if(invasor.getPosition().getY() + invasor.getPixelArt().getHeight()/2 >= endHeight){
                        reachedHeight = true;
                        break;
                    }
                }
            }
            if(reachedEdge)
                break;
        }
        if(reachedHeight) {
            endGame(false);
            return;
        }
        if(reachedEdge){
            direction *= -1;
            for(List<Invasor> line : invasors){
                for (Invasor invasor : line) {
                    if(invasor.isAlive()){
                        invasor.getPixelArt().move(invasor, 0, invasor.getPixelArt().getHeight()/2);
                    }
                }
            }
        }
        else{
            // initialHeight
            for(List<Invasor> line : invasors){
                for (Invasor invasor : line) {
                    if(invasor.isAlive()){
                        invasor.getPixelArt().move(invasor, invasor.getSpeedX()*direction,0);
                    }
                }
            }
        }
    }

    
    private Invasor createInvasor(InvasorType invasorType, int positionX, int baseHeight, int speed) {
        InvasorComponent invasorArt = invasorType.createInvasorArt(Constants.INVASOR_WIDTH, Constants.INVASOR_HEIGHT, Constants.PIXEL_SIZE);
        Invasor invasor = new Invasor(new Position((positionX * 50*1.2) + Constants.LIMIT_SCREEN_WIDTH, baseHeight), 1, invasorType.getSpeed() + speed, invasorType, invasorArt);
        invasor.print(root);
        return invasor;
    }

    private void createPlayer() {
        // Gera o player
        PlayerArt playerArt = new PlayerArt(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PIXEL_SIZE); 
        player = new Player(new Position(Constants.LIMIT_SCREEN_WIDTH + 20, totalY + Constants.LIMIT_SCREEN_HEIGHT - playerArt.getHeight() - 50), 3, 7, 0, 0, playerArt);
        player.print(root);

        // Gera a arte das vidas
        for(int i=0; i<player.getLives(); i++) {
            HearthArt hearthArt = new HearthArt(10, 8, Constants.PIXEL_SIZE, true);
            hearthArt.print(new Position((i*hearthArt.getWidth()*1.4) + Constants.LIMIT_SCREEN_WIDTH, Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT - 20), root);
        }
    }

    private void keyChange(KeyEvent event){
        event.consume();
        switch (event.getCode()) {
            case RIGHT:
                player.getPixelArt().move(player, player.getSpeedX(),0);
                break;

            case LEFT:
                player.getPixelArt().move(player, -player.getSpeedX(),0);
                break;
                
            case ENTER:
                this.shoot();
                break;           
            default:
                break;
        }
    }    

    private void shoot() {
        if(!player.isShooting()) {
            // Adiciona delay no tiro
            player.setIsShooting(true);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.setIsShooting(false);
                }
            }, delay);

            // Altera a quantidade de tiros que o player disparou
            player.addHit();
            hitsLabel.setText("Tiros: "+player.getHits());

            // Gera a arte do tiro
            BulletArt bulletArt = new BulletArt(1, 3, 5);
            Bullet bullet = new Bullet(new Position(player.getPosition().getX(), player.getPosition().getY()), bullet_speed, bulletArt);
            bullet.print(root);
    
            // Define o espaço percorrido
            double position = Constants.SCREEN_HEIGHT - initialHeight - player.getPosition().getX() - bulletArt.getWidth() - 2;
            // S = So + vt => t = (S - So) / v
            double time = (position * 190) / bullet.getSpeedY();
            // 180 é uma constante para não deixar nem muito lento, nem muito rápido

            TranslateTransition bulletTransition = new TranslateTransition();
            bulletTransition.setNode(bulletArt);
            bulletTransition.setDuration(Duration.millis(time));
            bulletTransition.setCycleCount(1); // Quantidade de execuções
            bulletTransition.setByY(-totalY + initialHeight); // Define até onde o tiro vai, sendo y=0 no topo da tela
            bulletTransition.setInterpolator(Interpolator.LINEAR); // Define velocidade constante
            bulletTransition.play();

            bulletTransition.setOnFinished(removeEvent -> {
                root.getChildren().remove(bulletArt);
            });
        }
    }
}
