package com.spaceinvaders.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.time.Duration;

public class SoundPlayer {
    protected  MediaPlayer mediaPlayer;
    protected  String soundFilePath;

    // Construtor que recebe o caminho do arquivo de som
    public SoundPlayer(String soundFilePath) {
        this.soundFilePath = soundFilePath;

        try {
            
            Media sound = new Media(new File(soundFilePath).toURI().toString());
            this.mediaPlayer = new MediaPlayer(sound);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    public SoundPlayer(String soundFilePath, double volume){
        this.soundFilePath = soundFilePath;

        try {
            
            Media sound = new Media(new File(soundFilePath).toURI().toString());
            this.mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(volume);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    
    public void playSound() {
        try{
            
            Media sound = new Media(new File(soundFilePath).toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setOnReady(() -> mediaPlayer.play());


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    public void playRepeat(){
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));
    }

    public void stop(){
        mediaPlayer.stop();
        mediaPlayer.seek(mediaPlayer.getStartTime());
    }

    public void setVolume(double volume){
        //valor de volume tem que estar entre 0.0 e 1.0
        mediaPlayer.setVolume(volume);
    }

}