package com.spaceinvaders.components;

import com.spaceinvaders.model.Bullet;
import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Element;
import com.spaceinvaders.model.Position;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HearthArt extends PixelArt{
    private boolean active;

    public HearthArt(int width, int height, int pixelSize, boolean active) {
        super(width, height, pixelSize);
        this.active = active;
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

        Color color = active == true ? Color.RED : Color.GRAY;

        Color[][] pixels = {
            {Color.TRANSPARENT, Color.TRANSPARENT, color, color, Color.TRANSPARENT, Color.TRANSPARENT, color, color, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, color, color, color, color, color, color, color, color, Color.TRANSPARENT},
            {color, color, color, color, color, color, color, color, color, color},
            {color, color, color, color, color, color, color, color, color, color},
            {Color.TRANSPARENT, color, color, color, color, color, color, color, color, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, color, color, color, color, color, color, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, color, color, color, color, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT},
            {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, color, color, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT}
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    @Override
    public void move(Element target, double x, double y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}