package com.spaceinvasors.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import com.spaceinvasors.model.Bullet;
import com.spaceinvasors.model.Character;

public class GameController implements Initializable {
    private Stage stage;
    private Scene scene;

    private List<List<InvasorComponent>> invasors = new ArrayList<>();

    @FXML
    private AnchorPane root;
    @FXML
    private Label hitsLabel;
    @FXML
    private Label pointsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setFocusTraversable(true);

        int height = 150;
        List<InvasorComponent> listAux;

        double speed_invasor = 10;
        double speed_bullet = 20;
        int totalX = Constants.SCREEN_WIDTH - 2*Constants.LIMIT_SCREEN_WIDTH;
        int totalY= Constants.SCREEN_HEIGHT - 2*Constants.LIMIT_SCREEN_HEIGHT;

        Player player = new Player(new Position(Constants.LIMIT_SCREEN_WIDTH + 50, totalY + Constants.LIMIT_SCREEN_HEIGHT - 40), 0, 5, 0, 0);
        PlayerArt playerArt = new PlayerArt(10, 10, 10,player); 
        root.getChildren().add(playerArt);

        Class<?>[] invasorTypes = new Class<?>[] {
            StrongInvasor.class,
            MidInvasor.class,
            FastInvasor.class,
        };


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

        // S=so+vt => S-so / v = t

        for (Class<?> invasorType : invasorTypes) {
            listAux = new ArrayList<>();
            int width = 6;
            for (int i = 0; i < 10; i++) {
                try {
                    Invasor invasor = new Invasor(new Position((i * 50) + Constants.LIMIT_SCREEN_WIDTH, height), 1, speed_invasor);
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

        root.setOnKeyPressed(event -> {
            event.consume(); 
            if (event.getCode() == KeyCode.A) {
                playerArt.move(-player.getSpeedX(), 0);
            } else if(event.getCode() == KeyCode.D) {
                playerArt.move(player.getSpeedX(), 0);
                playerArt.setLayoutX(player.getPosition().getX());
            } else if(event.getCode() == KeyCode.ENTER) {
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

                bulletTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                    for(List<InvasorComponent> invasorComponents : invasors) {
                        for(InvasorComponent invasor : invasorComponents) {
                                if (bulletArt.getBoundsInParent().intersects(invasor.getBoundsInParent())) {
                                    // Colisão detectada
                                    System.out.println("Colisão detectada!" + invasor.getClass() + " " + invasor.getLayoutX());
                    
                                    // Parar a animação
                                    bulletTransition.stop();

                                    player.addPoint();
                                    // invasor.stop();

                                    pointsLabel.setText("Pontos: "+player.getPoints());
                    
                                    // Remover o inimigo da tela
                                    root.getChildren().remove(invasor);
                                    root.getChildren().remove(bulletArt);
                                }
                        }
                    }
                });

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
