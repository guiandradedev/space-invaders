package com.spaceinvasors.components;

import com.spaceinvasors.model.Bullet;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BulletArt extends PixelArt {
    private Bullet bullet;

    public BulletArt(int width, int height, int pixelSize, Bullet bullet) {
        super(width, height, pixelSize);
        drawArt();

        bullet.getPosition().setY(bullet.getPosition().getY() - this.getHeight());

        this.setLayoutX(bullet.getPosition().getX());
        this.setLayoutY(bullet.getPosition().getY());
    }

    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        // Exemplo simples de arte pixelada: um quadrado de 4x4 pixels
        Color[][] pixels = {
            {Color.BLACK},
            {Color.BLACK},
            {Color.BLACK},
            {Color.BLACK
            }
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    @Override
    public void move(double x, double y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
