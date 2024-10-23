package com.spaceinvaders.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

import com.spaceinvaders.components.BarrierArt;
import com.spaceinvaders.components.BulletArt;
import com.spaceinvaders.components.HearthArt;
import com.spaceinvaders.components.InvasorComponent;
import com.spaceinvaders.components.PlayerArt;
import com.spaceinvaders.enums.InvasorType;
import com.spaceinvaders.model.Barrier;
import com.spaceinvaders.model.Bullet;
import com.spaceinvaders.model.Intersection;
import com.spaceinvaders.model.Invasor;
import com.spaceinvaders.model.Player;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.text.Font;

public class GameController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Label hitsLabel;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label nameLabel;

    // Constantes
    private final int totalX = Constants.SCREEN_WIDTH - 2*Constants.LIMIT_SCREEN_WIDTH;
    private final int totalY = Constants.SCREEN_HEIGHT - 2*Constants.LIMIT_SCREEN_HEIGHT;
    private final int initialHeight = Constants.LIMIT_SCREEN_HEIGHT + 100;
    private final int endHeight = totalY + Constants.LIMIT_SCREEN_HEIGHT - (Constants.PLAYER_HEIGHT * Constants.PIXEL_SIZE) - 50 - (Constants.BARRIER_HEIGHT * Constants.PIXEL_SIZE) - 20;
    private final int delay = 500; // em ms
    private final int totalEnemiesInLine = 11;
    private int totalEnemies = 0;

    // Variaveis
    private int level = 1;
    private int bullet_speed = 200;
    private int timer_animation = 500;
    private short direction = 1; // true para direita, false para a esquerda 
    private int invasorsKilled = 0;
    private int seconds = 0;

    private Timeline timeline;
    private Timeline stopwatch;

    private Set<KeyCode> keyqueue= new HashSet<>();

    // Personagens
    private Player player;
    private List<List<Invasor>> invasors = new ArrayList<>();
    private List<Barrier> barriers = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);

        timerLabel.setFont(Constants.FONT_SANS);
        pointsLabel.setFont(Constants.FONT_SANS);
        hitsLabel.setFont(Constants.FONT_SANS);
        nameLabel.setFont(Constants.FONT_MONO);
        
    
        startGame();

        Platform.runLater(() -> root.requestFocus());

        root.setOnKeyPressed(event ->{
            keyqueue.add(event.getCode());
        });

        root.setOnKeyReleased(event -> {
            keyqueue.remove(event.getCode());
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                keyChange(); 
            }
        };

        timer.start();
        
        root.requestFocus();
    }

    private void startGame() {
        invasorsKilled = 0;
        hitsLabel.setText("Tiros: 0");
        pointsLabel.setText("Pontos: 0");
        direction = 1;

        createPlayer();
        generateInvasors(0);
        createBarriers();

        timer();

        animation();
    }
    
    private void createBarriers() {
        barriers = new ArrayList<>();
        for(int i=0; i<4; i++) {
            BarrierArt barrierArt = new BarrierArt(Constants.BARRIER_WIDTH, Constants.BARRIER_HEIGHT, Constants.PIXEL_SIZE);
            Barrier barrier = new Barrier(new Position((i * 50 * 3.5) + Constants.LIMIT_SCREEN_WIDTH + 50, endHeight), barrierArt);
            barrier.print(root);;
            barriers.add(barrier);
        }
    }

    public void generateInvasors(int baseSpeed) {
        int baseHeight = initialHeight;
        List<Invasor> aux;
        invasors = new ArrayList<>();
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

    
    private void endGame(boolean won) {
        if (timeline != null) {
            timeline.stop();
        }
        
        String info = won ? "Ganhou" : "Perdeu";
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Informação Importante");
            alert.setHeaderText("Você " + info + "!");
            alert.setContentText("Total de pontos obtidos: " + player.getPoints());
            
            ButtonType customButton = new ButtonType("Recomeçar", ButtonBar.ButtonData.OK_DONE);
            ButtonType closeButton = new ButtonType("Sair", ButtonBar.ButtonData.CANCEL_CLOSE);
            
            alert.getButtonTypes().setAll(customButton, closeButton);
            
            alert.showAndWait().ifPresent(response -> {
                if (response == customButton) {
                    root.getChildren().remove(player.getPixelArt());
                    
                    for(List<Invasor> line : invasors) {
                        for(Invasor invasor : line) {
                            root.getChildren().remove(invasor.getPixelArt());
                        }
                    }

                    for(Barrier barrier : barriers) {
                        root.getChildren().remove(barrier.getPixelArt());
                    }
                    
                    startGame();
                } else {
                    Alert secondAlert = new Alert(Alert.AlertType.INFORMATION);
                    secondAlert.setTitle("Finalizando");
                    secondAlert.setHeaderText("Obrigado por jogar");
                    secondAlert.setContentText("O programa será encerrado.");
                    secondAlert.showAndWait();
                    
                    Platform.exit(); // Fecha o programa
                    System.exit(0); // Finaliza a aplicação
                }
            });
        });
    }

    private void timer() {
        stopwatch = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer(timerLabel)));
        stopwatch.setCycleCount(Timeline.INDEFINITE); 
        stopwatch.play(

        );
    }
    private void updateTimer(Label timerLabel) {
        seconds++;
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, remainingSeconds));
    }
    
    private void animation() {
        timeline = new Timeline(new KeyFrame(Duration.millis(timer_animation), e -> moveAliens(invasors)));
        timeline.setCycleCount(Timeline.INDEFINITE); // Executa indefinidamente
        timeline.play(); // Inicia o movimento
    }

    private int getAnimationDelay(int invasorsKilled) {
        if (invasorsKilled >= 0 && invasorsKilled <= 5) return 500; // P1
        if (invasorsKilled > 5 && invasorsKilled <= 10) return 425; // P2
        if (invasorsKilled > 10 && invasorsKilled <= 15) return 360; // P3
        if (invasorsKilled > 15 && invasorsKilled <= 20) return 250; // P4
        if (invasorsKilled > 20 && invasorsKilled <= 25) return 155;  // P5
        if (invasorsKilled > 25 && invasorsKilled <= 30) return 80;  // P6
        if (invasorsKilled > 30 && invasorsKilled <= 35) return 45;  // P7
        if (invasorsKilled > 35 && invasorsKilled <= 40) return 30;  // P8
        if (invasorsKilled > 40 && invasorsKilled <= 45) return 20;  // P9
        if (invasorsKilled > 45 && invasorsKilled <= 50) return 15;  // P9
        return 5; // Pmin
    }
    
    private void moveAliens(List<List<Invasor>> invasors){
        int delay = getAnimationDelay(invasorsKilled);
        if(delay != timer_animation) {
            timer_animation = delay;
            timeline.stop();
            animation();
            return;
        }

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
        if(invasorsKilled == totalEnemies) {
            endGame(true);
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
            for(List<Invasor> line : invasors){
                for (Invasor invasor : line) {
                    if(invasor.isAlive()){
                        if(invasor.getPixelArt().getState() != "Dead") {
                            invasor.getPixelArt().changeState();
                        }
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
        player = new Player(new Position(Constants.LIMIT_SCREEN_WIDTH + 20, totalY + Constants.LIMIT_SCREEN_HEIGHT - playerArt.getHeight() - 50), 3, 1.3, 0, 0, playerArt);
        player.print(root);

        // Gera a arte das vidas
        for(int i=0; i<player.getLives(); i++) {
            HearthArt hearthArt = new HearthArt(10, 8, Constants.PIXEL_SIZE, true);
            hearthArt.print(new Position((i*hearthArt.getWidth()*1.4) + Constants.LIMIT_SCREEN_WIDTH, Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT - 20), root);
        }
    }

    private void keyChange(){
        if (keyqueue.contains(KeyCode.RIGHT)) {
            player.getPixelArt().move(player, player.getSpeedX(), 0);
        }

        if (keyqueue.contains(KeyCode.LEFT)) {
            player.getPixelArt().move(player, -player.getSpeedX(), 0);
        }

        if (keyqueue.contains(KeyCode.SPACE)) {
            shoot(); // Disparar tiro
        }
    }    

    private void shoot() {
        if(!player.isShooting()) {
            // Adiciona delay no tiro
            player.setIsShooting(true);
            player.playSound();
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
            BulletArt bulletArt = new BulletArt(1, 4, Constants.PIXEL_SIZE);
            Bullet bullet = new Bullet(new Position(player.getPosition().getX(), player.getPosition().getY()), bullet_speed, bulletArt);
            bullet.print(root);
    
            // Define o espaço percorrido
            double position = totalY - (Constants.SCREEN_HEIGHT - player.getPosition().getY());
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


            // Colisao
            final boolean[] isValidated = { false };

            bulletTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {

                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                   // Verifica colisao com inimigos
                    int i=0;
                    for(List<Invasor> line : invasors) {
                        for(Invasor invasor : line) {
                            if (bulletArt.getBoundsInParent().intersects(invasor.getPixelArt().getBoundsInParent()) && !isValidated[0] && invasor.isAlive() && invasor.getPixelArt().getState() != "Dead") {
                                isValidated[0] = true;

                                // System.out.println("Bala "+ bulletArt.getBoundsInParent());
                                // System.out.println("Invasor "+invasor.getPixelArt().getBoundsInParent());

                                player.shoot(invasor, root);
                                
                                // System.out.println("Colisão detectada!" + invasor.getClass() + " " + invasor.getPixelArt().getLayoutX() + " " + i);
                                pointsLabel.setText("Pontos: "+player.getPoints());
                                
                                bulletTransition.stop();
                                root.getChildren().remove(bulletArt);
                                bulletTransition.currentTimeProperty().removeListener(this);

                                invasorsKilled++;
                            }
                            i++;
                        }
                    }

                    // Verifica colisao com barreiras
                    for(Barrier barrier : barriers) {
                        Bounds bulletBound = bulletArt.getBoundsInParent();
                        Bounds barrierBound = barrier.getPixelArt().getBoundsInParent();
                        
                        if (bulletBound.intersects(barrierBound)) {
                    
                            // Encontra a intersecção da colisão
                            Position min = new Position(Math.max(bulletBound.getMinX(), barrierBound.getMinX()), Math.max(bulletBound.getMinY(), barrierBound.getMinY()));
                            Position max = new Position(Math.min(bulletBound.getMaxX(), barrierBound.getMaxX()), Math.min(bulletBound.getMaxY(), barrierBound.getMaxY()));
                            Intersection intersection = new Intersection(min, max);

                            // Confirma que realmente existe intersecção
                            if(intersection.hasIntersection()) {
                                double intersectX = min.getX() - barrierBound.getMinX();
                                double intersectY = min.getY() - barrierBound.getMinY();

                                // Transforma a imagem
                                WritableImage snapshot = new WritableImage((int) barrier.getPixelArt().getWidth(), (int) barrier.getPixelArt().getHeight());
                                barrier.getPixelArt().snapshot(null, snapshot);
                                PixelReader pixelReader = snapshot.getPixelReader();

                                if (pixelReader != null) {
                                    int pixelX = (int) Math.floor(intersectX);
                                    int pixelY = (int) Math.floor(intersectY);

                                    Color color = pixelReader.getColor(pixelX, pixelY);
                                    if(color.equals(Color.GREEN)) {
                                        barrier.takeDamage(intersection);
                                        
                                        bulletTransition.stop();
                                        root.getChildren().remove(bulletArt);
                                        bulletTransition.currentTimeProperty().removeListener(this);
                                    }
                                }
                            }
                        }
                    }
                }
            });


            bulletTransition.setOnFinished(removeEvent -> {
                root.getChildren().remove(bulletArt);
            });
        }
    }
}
