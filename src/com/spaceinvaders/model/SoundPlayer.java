package com.spaceinvaders.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundPlayer {
    private MediaPlayer mediaPlayer;

    // Construtor que recebe o caminho do arquivo de som
    public SoundPlayer(String soundFilePath) {
        System.out.println("Caminho do arquivo de som: " + soundFilePath);

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
        if (mediaPlayer != null) {
            mediaPlayer.play();
            
            // Quando o som terminar, ele volta ao início (caso queira reproduzir de novo)
            mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));
        }
    }

    // Método para parar o som
    public void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
