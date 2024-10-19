package com.spaceinvasors.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.spaceinvasors.model.Invasor;
import com.spaceinvasors.model.Player;
import com.spaceinvasors.model.Position;
import com.spaceinvasors.utils.Constants;
import com.spaceinvasors.components.BulletArt;
import com.spaceinvasors.components.FastInvasor;
import com.spaceinvasors.components.InvasorComponent;
import com.spaceinvasors.components.MidInvasor;
import com.spaceinvasors.components.PlayerArt;
import com.spaceinvasors.components.StrongInvasor;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import com.spaceinvasors.model.Bullet;
import com.spaceinvasors.model.Character;

public class GameController implements Initializable {
    // Interface
    private Stage stage;
    private Scene scene;

    @FXML
    private AnchorPane root;
    @FXML
    private Label hitsLabel;
    @FXML
    private Label pointsLabel;

    // Constantes
    private final int totalX = Constants.SCREEN_WIDTH - 2*Constants.LIMIT_SCREEN_WIDTH;
    private final int totalY = Constants.SCREEN_HEIGHT - 2*Constants.LIMIT_SCREEN_HEIGHT;
    private final long delay = 500;

    // Variaveis
    private boolean canExecute = true;
    private int height = 100;
    private int speed_invasor = 10;
    private int speed_bullet = 20;

    // Personagens
    private List<List<InvasorComponent>> invasors = new ArrayList<>();
    private List<TranslateTransition> transitions = new ArrayList<>();
    private Player player;
    private PlayerArt playerArt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);

        generateBorders();
        createPlayer();
        createInvasors();

        root.setOnKeyPressed(this::keyChange);

        root.requestFocus();
    }

    private void createPlayer() {
        player = new Player(new Position(Constants.LIMIT_SCREEN_WIDTH + 50, totalY + Constants.LIMIT_SCREEN_HEIGHT - 40), 0, 5, 0, 0);
        playerArt = new PlayerArt(10, 10, 10,player); 
        root.getChildren().add(playerArt);
    }

    private void keyChange(KeyEvent event) {
        event.consume(); 
        if (event.getCode() == KeyCode.A) {
            playerArt.move(-player.getSpeedX(), 0);
        } else if(event.getCode() == KeyCode.D) {
            playerArt.move(player.getSpeedX(), 0);
            playerArt.setLayoutX(player.getPosition().getX());
        } else if(event.getCode() == KeyCode.ENTER) {
            if(canExecute) {
                canExecute = false;

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        canExecute = true;  // Libera o listener após o tempo definido
                    }
                }, delay);

                player.addHit();
                hitsLabel.setText("Tiros: "+player.getHits());

                Bullet bullet = new Bullet(new Position(player.getPosition().getX(), player.getPosition().getY()), speed_bullet);
                // System.out.println(player.getPosition().getX() + " " + player.getPosition().getY());
                BulletArt bulletArt = new BulletArt(1, 3, 5, bullet);

                TranslateTransition bulletTransition = new TranslateTransition();
                bulletTransition.setNode(bulletArt);
                bulletTransition.setDuration(Duration.millis(200 * bullet.getSpeedY()));
                bulletTransition.setCycleCount(1);
                bulletTransition.setByY(-totalY + 50);
                bulletTransition.setInterpolator(Interpolator.LINEAR); // Definindo interpolação linear (velocidade constante)
                bulletTransition.play();

                final boolean[] isValidated = { false };

                bulletTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {

                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                        int i=0;
                        for(List<InvasorComponent> invasorComponents : invasors) {
                            for(InvasorComponent invasor : invasorComponents) {
                                if (bulletArt.getBoundsInParent().intersects(invasor.getBoundsInParent()) && !isValidated[0] && !invasor.getCharacter().isHitted()) {
                                    // Colisão detectada
                                    System.out.println("Colisão detectada!" + invasor.getClass() + " " + invasor.getLayoutX() + " " + i);
                                    isValidated[0] = true;
                                    // // Parar a animação
                                    bulletTransition.stop();
    
                                    // TranslateTransition transition = transitions.get(i);
                                    // transitions.remove(i);
                                    // transition.stop();
                                    // // // invasor.stop();

                                    invasor.getCharacter().setHitted();

                                    player.shoot(invasor.getCharacter());

                                    if(invasor.getClass() == StrongInvasor.class) {
                                        player.addPoints(3);
                                    } else if(invasor.getClass() == MidInvasor.class) {
                                        player.addPoints(2);
                                    } else {
                                        player.addPoint();
                                    }
                                    System.out.println(player.getPoints());

                                    pointsLabel.setText("Pontos: "+player.getPoints());
                                    
                                    // // Remover o inimigo da tela
                                    root.getChildren().remove(invasor);
                                    root.getChildren().remove(bulletArt);
                                    bulletTransition.currentTimeProperty().removeListener(this);
                                }
                                i++;
                            }
                        }
                        i=0;
                    }
                });
                // bulletTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                //     int i=0;
                //     for(List<InvasorComponent> invasorComponents : invasors) {
                //         for(InvasorComponent invasor : invasorComponents) {
                //             if (bulletArt.getBoundsInParent().intersects(invasor.getBoundsInParent())) {
                //                 // Colisão detectada
                //                 System.out.println("Colisão detectada!" + invasor.getClass() + " " + invasor.getLayoutX() + " " + i);
                                
                //                 // // Parar a animação
                //                 bulletTransition.stop();
                                
                //                 // player.addPoint();
                //                 // System.out.println(player.getPoints());

                //                 // // TranslateTransition transition = transitions.get(i);
                //                 // // transitions.remove(i);
                //                 // // transition.stop();
                //                 // // // invasor.stop();
                                
                //                 // pointsLabel.setText("Pontos: "+player.getPoints());
                                
                //                 // // Remover o inimigo da tela
                //                 // root.getChildren().remove(invasor);
                //                 root.getChildren().remove(bulletArt);
                //                 return;
                //             }
                //             i++;
                //         }
                //     }
                //     i=0;
                // });

                // for(List<InvasorComponent> invasorComponents : invasors) {
                //     for(InvasorComponent invasor : invasorComponents) {
                //         if (bulletArt.getBoundsInParent().intersects(invasor.getBoundsInParent())) {
                //             // Colisão detectada
                //             System.out.println("Colisão detectada!" + invasor.getLayoutX());
            
                //             // // Parar a animação
                //             // bulletTransition.stop();
                //             // // invasor.stop();
            
                //             // // Remover o inimigo da tela
                //             // root.getChildren().remove(invasor);
                //         }
                //     }
                // }

                // Adiciona o BulletArt à cena
                root.getChildren().add(bulletArt);

                // Adiciona um listener para executar uma ação após a animação terminar
                bulletTransition.setOnFinished(removeEvent -> {
                    // Remove o BulletArt da cena
                    root.getChildren().remove(bulletArt);
                });


            }
            
        }
    }

    private void createInvasors() {
        List<InvasorComponent> listAux;

        Class<?>[] invasorTypes = new Class<?>[] {
            StrongInvasor.class,
            MidInvasor.class,
            FastInvasor.class,
        };

        for (Class<?> invasorType : invasorTypes) {
            listAux = new ArrayList<>();
            int width = 6;
            for (int i = 0; i < 10; i++) {
                try {
                    Invasor invasor = new Invasor(new Position((i * 50) + Constants.LIMIT_SCREEN_WIDTH, height), 1, speed_invasor, invasorType.getSimpleName());
                    double time = totalX * invasor.getSpeedX();

                    InvasorComponent invasorArt = (InvasorComponent) invasorType
                        .getDeclaredConstructor(int.class, int.class, int.class, Character.class)
                        .newInstance(5, 5, 10, invasor);

                    width -= invasorArt.getWidth() - 10;

                    TranslateTransition enemyTransition = new TranslateTransition();
                    enemyTransition.setNode(invasorArt);
                    enemyTransition.setDuration(Duration.millis(time));
                    enemyTransition.setCycleCount(TranslateTransition.INDEFINITE) ;
                    enemyTransition.setByX(2*invasorArt.getWidth() + 10);
                    enemyTransition.setAutoReverse (true);
                    enemyTransition.setInterpolator(Interpolator.LINEAR); // Definindo interpolação linear (velocidade constante)
                    enemyTransition.play();

                    transitions.add(enemyTransition);

                    // enemyTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                    //     // Verificar colisão entre player e enemy
                    //     if (playerArt.getBoundsInParent().intersects(invasorArt.getBoundsInParent())) {
                    //         // Colisão detectada
                    //         System.out.println("Colisão detectada!");
            
                    //         // Parar a animação
                    //         enemyTransition.stop();
            
                    //         // Remover o inimigo da tela
                    //         root.getChildren().remove(invasorArt);
                    //     }
                    // });
            

                    listAux.add(invasorArt);
        
                    root.getChildren().add(invasorArt);
        
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
            invasors.add(listAux);
            height += 50;
            // timer += 1000;

        }
    }

    private void generateBorders() {
        Line line = new Line();
        line.setStartX(totalX + Constants.LIMIT_SCREEN_WIDTH);
        line.setEndX(totalX + Constants.LIMIT_SCREEN_WIDTH);
        line.setStartY(Constants.LIMIT_SCREEN_HEIGHT);
        line.setEndY(totalY + Constants.LIMIT_SCREEN_HEIGHT);
        root.getChildren().add(line);

        Line line2 = new Line();
        line2.setStartX(Constants.LIMIT_SCREEN_WIDTH);
        line2.setEndX(Constants.LIMIT_SCREEN_WIDTH);
        line2.setStartY(Constants.LIMIT_SCREEN_HEIGHT);
        line2.setEndY(totalY + Constants.LIMIT_SCREEN_HEIGHT);
        root.getChildren().add(line2);

        Line line3 = new Line();
        line3.setStartY(totalY + Constants.LIMIT_SCREEN_HEIGHT);
        line3.setEndY(totalY + Constants.LIMIT_SCREEN_HEIGHT);
        line3.setStartX(Constants.LIMIT_SCREEN_WIDTH);
        line3.setEndX(totalX + Constants.LIMIT_SCREEN_WIDTH);
        root.getChildren().add(line3);

        Line line4 = new Line();
        line4.setStartY(Constants.LIMIT_SCREEN_HEIGHT);
        line4.setEndY(Constants.LIMIT_SCREEN_HEIGHT);
        line4.setStartX(Constants.LIMIT_SCREEN_WIDTH);
        line4.setEndX(totalX + Constants.LIMIT_SCREEN_WIDTH);
        root.getChildren().add(line4);
    }

    public void backMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/spaceinvasors/view/Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
