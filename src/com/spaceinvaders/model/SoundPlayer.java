package com.spaceinvaders.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundPlayer {
    protected  MediaPlayer mediaPlayer;
    protected  String soundFilePath;

    // Construtor que recebe o caminho do arquivo de som
    public SoundPlayer(String soundFilePath) {
        this.soundFilePath = soundFilePath;

        try {
            // Carrega o arquivo de som
            Media sound = new Media(new File(soundFilePath).toURI().toString());
            this.mediaPlayer = new MediaPlayer(sound);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    // Método para tocar o som
    public void playSound() {
        try{
            // Carrega o arquivo de som
            Media sound = new Media(new File(soundFilePath).toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();

            mediaPlayer.setOnEndOfMedia(() -> {
                System.out.println("Som terminou de tocar.");
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }
}