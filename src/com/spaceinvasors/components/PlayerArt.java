package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlayerArt extends ElementArt{
    public PlayerArt(int width, int height, int pixelSize, Character character) {
        super(width, height, pixelSize, character);
        drawArt();
    }

    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        // Exemplo simples de arte pixelada: um quadrado de 4x4 pixels
        Color[][] pixels = {
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.RED, Color.RED, Color.BLACK},
            {Color.BLACK, Color.RED, Color.RED, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK}

            // quadrado 4:4
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
