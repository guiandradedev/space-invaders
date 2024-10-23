package com.spaceinvaders.utils;

import javafx.scene.text.Font;
import java.io.InputStream;

public class Constants {
    // Dimensões da tela
    public static final int SCREEN_WIDTH = 750;
    public static final int SCREEN_HEIGHT = 800;
    public static final int LIMIT_SCREEN_WIDTH = 25;
    public static final int LIMIT_SCREEN_HEIGHT = 25;

    // Outras constantes
    public static final String GAME_TITLE = "Space Invaders";
    public static final int PLAYER_WIDTH = 15; // em px
    public static final int PLAYER_HEIGHT = 15;
    public static final int INVASOR_WIDTH = 15; // em px
    public static final int INVASOR_HEIGHT = 15;
    public static final int BARRIER_HEIGHT = 24;
    public static final int BARRIER_WIDTH = 24;
    public static final int PIXEL_SIZE = 3;

    // Fontes
    public static Font FONT_MONO;
    public static Font FONT_SANS;
    public static Font FONT_SANS_BOLD;

    static {
        try {
            // Carrega as fontes dentro do bloco estático
            InputStream monoStream = Constants.class.getResourceAsStream("/com/spaceinvaders/assets/fonts/PixeloidMono.ttf");
            InputStream sansStream = Constants.class.getResourceAsStream("/com/spaceinvaders/assets/fonts/PixeloidSans.ttf");
            InputStream sansBoldStream = Constants.class.getResourceAsStream("/com/spaceinvaders/assets/fonts/PixeloidSansBold.ttf");

            if (monoStream != null) {
                FONT_MONO = Font.loadFont(monoStream, 20);
            }
            if (sansStream != null) {
                FONT_SANS = Font.loadFont(sansStream, 20);
            }
            if (sansBoldStream != null) {
                FONT_SANS_BOLD = Font.loadFont(sansBoldStream, 20);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar as fontes: " + e.getMessage());
        }
    }
}
