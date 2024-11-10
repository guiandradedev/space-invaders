package com.spaceinvaders.components;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StrongInvasor extends InvasorComponent{
    public StrongInvasor(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        setPixels(initialState());;
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

    public Color[][] initialState() {
        return new Color[][] {
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK},
            {Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN     },
            {Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN     },
            {Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
        };
    }
    public Color[][] movingState() {
        return new Color[][] {
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK,       Color.GREEN,       Color.GREEN,       Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN,       Color.GREEN,       Color.BLACK, Color.BLACK,       Color.GREEN,       Color.BLACK},
            {Color.GREEN,       Color.GREEN,       Color.GREEN, Color.GREEN, Color.GREEN,       Color.GREEN,       Color.BLACK,       Color.BLACK,       Color.BLACK,       Color.GREEN,       Color.GREEN,       Color.GREEN, Color.GREEN, Color.GREEN,       Color.GREEN     },
            {Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN     },
            {Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK},
            {Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK},
            {Color.GREEN, Color.GREEN,  Color.BLACK,       Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK, Color.GREEN,       Color.BLACK, Color.BLACK,       Color.GREEN,       Color.GREEN},
            {Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,       Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK},
        };
    }

    public Color[][] deadState() {
        return new Color[][] {
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
        };
    }


}
