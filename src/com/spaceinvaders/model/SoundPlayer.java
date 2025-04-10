package com.spaceinvaders.model;

import javafx.scene.media.AudioClip;
import java.io.File;

public class SoundPlayer {
    protected AudioClip audioClip;
    protected String soundFilePath;

    // Construtor que recebe o caminho do arquivo de som
    public SoundPlayer(String soundFilePath) {
        this.soundFilePath = soundFilePath;

        try {
            audioClip = new AudioClip(new File(soundFilePath).toURI().toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    public SoundPlayer(String soundFilePath, double volume) {
        this.soundFilePath = soundFilePath;

        try {
            audioClip = new AudioClip(new File(soundFilePath).toURI().toString());
            setVolume(volume);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo de som!");
        }
    }

    public void playSound() {
        try {
            audioClip.play();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tocar o arquivo de som!");
        }
    }

    public void playRepeat() {
        try {
            audioClip.setCycleCount(AudioClip.INDEFINITE);  // Repetir indefinidamente
            audioClip.play();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tocar o arquivo de som!");
        }
    }

    public void stop() {
        audioClip.stop();
    }

    public void setVolume(double volume) {
        // valor de volume tem que estar entre 0.0 e 1.0
        audioClip.setVolume(volume);
    }
}
