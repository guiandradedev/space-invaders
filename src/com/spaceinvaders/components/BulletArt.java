package com.spaceinvaders.components;

import com.spaceinvaders.model.Bullet;
import com.spaceinvaders.model.Element;
import com.spaceinvaders.model.Position;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BulletArt extends MovableArt {
    public BulletArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        drawArt();
    }

    @Override
    public void printArt(Position position) {
        this.drawArt();

        position.setY(position.getY() - this.getHeight() - 2);
        position.setX(position.getX() + (this.getPixelSize() * this.getWidth())/2 + 11);

        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());
    }

    public void drawArt() {
        GraphicsContext gc = getGraphicsContext2D();
        int pixelSize = this.getPixelSize();

        // Exemplo simples de arte pixelada: um quadrado de 4x4 pixels
        Color[][] pixels = {
            {Color.RED},
            {Color.RED},
            {Color.RED},
            {Color.RED}
        };

        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                gc.setFill(pixels[y][x]);
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }

    public void move(Element target, double x, double y) {
        if(target instanceof Bullet) {
            Bullet bullet = (Bullet)target;
        }
    }
    

}
