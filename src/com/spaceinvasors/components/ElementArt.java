package com.spaceinvasors.components;

import com.spaceinvasors.model.Character;
import com.spaceinvasors.utils.Constants;

import javafx.scene.canvas.Canvas;

public abstract class ElementArt extends PixelArt{
    private final Character character;

    public ElementArt(int width, int height, int pixelSize, Character character) {
        super(width, height, pixelSize);
        this.character = character;

        this.setLayoutX(character.getPosition().getX());
        this.setLayoutY(character.getPosition().getY());
    }

    public abstract void drawArt();

    public Character getCharacter(){
        return this.character;
    }

    public void move(double x, double y) {
        double newX = this.character.getPosition().getX() + x;
        double newY = this.character.getPosition().getY() + y;

        if (newX >= Constants.LIMIT_SCREEN_WIDTH && newX <= Constants.SCREEN_WIDTH - Constants.LIMIT_SCREEN_WIDTH - 40) {
            character.move(newX, this.character.getPosition().getY());
            this.setLayoutX(newX);
        }
    
        if (newY >= Constants.LIMIT_SCREEN_HEIGHT && newY <= Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT - this.getPixelSize()) {
            character.move(this.character.getPosition().getX(), newY);
            this.setLayoutY(newY);
        }
    }

}
