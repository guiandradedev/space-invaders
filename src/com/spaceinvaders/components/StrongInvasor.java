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
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN     },
            {Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN     },
            {Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
        };
    }
    public Color[][] movingState() {
        return new Color[][] {
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.GREEN     },
            {Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.GREEN     },
            {Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.GREEN,       Color.GREEN,       Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.GREEN,       Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK},
            {Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK},
            {Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.LIGHTPINK, Color.BLUE},
            {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
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
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
            {Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.YELLOW},
        };
    }


}
