package com.spaceinvaders.components;

import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Element;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.utils.Constants;

import javafx.scene.canvas.Canvas;

public abstract class PixelArt extends Canvas{
    private final int pixelSize; // Tamanho de cada pixel

    public PixelArt(int width, int height, int pixelSize) {
        super(width * pixelSize, height * pixelSize);
        this.pixelSize = pixelSize;
    }

    public abstract void drawArt();
    public void printArt(Position position) {
        this.drawArt();

        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());
    }
    public abstract void move(Element character, double x, double y);

    public int getPixelSize() {
        return this.pixelSize;
    }

}
