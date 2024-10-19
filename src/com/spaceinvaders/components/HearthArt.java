package com.spaceinvaders.components;

import com.spaceinvaders.model.Bullet;
import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Position;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HearthArt extends PixelArt{
    public HearthArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        drawArt();
    }

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }

    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        Color[][] pixels = {
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.RED, Color.RED, Color.TRANSPARENT, Color.TRANSPARENT, Color.RED, Color.RED, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.TRANSPARENT},
            {Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED},
            {Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED},
            {Color.TRANSPARENT, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.RED, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.RED, Color.RED, Color.RED, Color.RED, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.RED, Color.RED, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    @Override
    public void move(Character character, double x, double y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}