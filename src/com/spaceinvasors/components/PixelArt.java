package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;
import com.spaceinvasors.utils.Constants;

import javafx.scene.canvas.Canvas;

public abstract class PixelArt extends Canvas{
    private final int pixelSize; // Tamanho de cada pixel
    private final Character character;

    public PixelArt(int width, int height, int pixelSize, Character character) {
        super(width * pixelSize, height * pixelSize);
        this.character = character;
        this.pixelSize = pixelSize;

        this.setLayoutX(character.getPosition().getX());
        this.setLayoutY(character.getPosition().getY());
    }

    public abstract void drawArt();

    public void move(int x, int y) {
        double newX = this.character.getPosition().getX() + x;
        double newY = this.character.getPosition().getY() + y;
    
        // Verifica limites horizontal
        if (newX >= 0 && newX <= Constants.SCREEN_WIDTH - this.getWidth()) {
            character.move(newX, this.character.getPosition().getY());
            this.setLayoutX(newX);
        }
    
        // Verifica limites vertical
        if (newY >= 0 && newY <= Constants.SCREEN_HEIGHT - this.getHeight()) {
            character.move(this.character.getPosition().getX(), newY);
            this.setLayoutY(newY);
        }
    }
    

    public int getPixelSize() {
        return this.pixelSize;
    }

}
