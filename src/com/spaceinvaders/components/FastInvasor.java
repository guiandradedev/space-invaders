package com.spaceinvaders.components;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FastInvasor extends InvasorComponent{
    public FastInvasor(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        setPixels(initialState());
        drawArt();
    }

    @Override
    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        for (int y = 0; y < getPixels().length; y++) {
            for (int x = 0; x < getPixels()[y].length; x++) {
                gc.setFill(getPixels()[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public Color[][] initialState(){
            // Color trans = Color.BLACK;
            // Color COLOR.WHITE = Color.WHITE;

        return new Color[][]{
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
        };
    }

    public Color[][] movingState() {
        return new Color[][] {
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK},
        };
    }

}
