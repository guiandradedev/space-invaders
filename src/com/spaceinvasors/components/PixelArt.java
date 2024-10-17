package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;
import com.spaceinvasors.utils.Constants;

import javafx.scene.canvas.Canvas;

public abstract class PixelArt extends Canvas{
    private final int pixelSize; // Tamanho de cada pixel

    public PixelArt(int width, int height, int pixelSize) {
        super(width * pixelSize, height * pixelSize);
        this.pixelSize = pixelSize;
    }

    public abstract void drawArt();
    public abstract void move(double x, double y);

    public int getPixelSize() {
        return this.pixelSize;
    }

}
