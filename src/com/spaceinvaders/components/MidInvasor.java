package com.spaceinvaders.components;

import com.spaceinvaders.model.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MidInvasor extends InvasorComponent{
    public MidInvasor(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        drawArt();
    }

    @Override
    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        // Exemplo simples de arte pixelada: um quadrado de 4x4 pixels
        Color[][] pixels = {
            {Color.PINK, Color.PINK, Color.PINK, Color.PINK},
            {Color.PINK, Color.RED, Color.RED, Color.PINK},
            {Color.PINK, Color.RED, Color.RED, Color.PINK},
            {Color.PINK, Color.PINK, Color.PINK, Color.PINK}
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
