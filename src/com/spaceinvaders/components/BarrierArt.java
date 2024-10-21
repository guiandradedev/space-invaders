package com.spaceinvaders.components;

import com.spaceinvaders.model.Intersection;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BarrierArt extends StaticArt{
    public BarrierArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
    }

    private Color[][] pixels = new Color[Constants.BARRIER_WIDTH][Constants.BARRIER_HEIGHT];

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }

    @Override
    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                pixels[i][j] = Color.GREEN; // Define todas as posições como verde, preenchendo o quadrado
            }
        }

        // Color[][] pixels = {
        //     {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
        //     {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
        // };
        

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public void repaint(Intersection intersection) {
        int pixelX = (int) ((intersection.getMidPointX() - this.getLayoutX()) / Constants.PIXEL_SIZE);
        int pixelY = (int) ((intersection.getMidPointY() - this.getLayoutY()) / Constants.PIXEL_SIZE);
    
        if (pixelX >= 0 && pixelX < pixels.length && pixelY >= 0 && pixelY < pixels[0].length) {
            pixels[pixelX][pixelY] = Color.BLUEVIOLET;
        }

        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();
    
        gc.setFill(pixels[pixelX][pixelY]);
        gc.fillRect(pixelX * pixelSize, pixelY * pixelSize, pixelSize, pixelSize);
    
    }
}
