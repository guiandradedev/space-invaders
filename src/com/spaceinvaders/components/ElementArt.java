package com.spaceinvaders.components;

import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Element;
import com.spaceinvaders.utils.Constants;

import javafx.scene.canvas.Canvas;

public abstract class ElementArt extends PixelArt{
    // private final Character character;

    public ElementArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        // this.character = character;

        // this.setLayoutX(character.getPosition().getX());
        // this.setLayoutY(character.getPosition().getY());
    }

    public abstract void drawArt();

    public void move(Element target, double x, double y) {
        if(target instanceof Character) {
            Character character = (Character)target;
            
            double newX = character.getPosition().getX() + x;
            double newY = character.getPosition().getY() + y;
    
            if (newX >= Constants.LIMIT_SCREEN_WIDTH && newX <= Constants.SCREEN_WIDTH - Constants.LIMIT_SCREEN_WIDTH - 40) {
                character.move(newX, character.getPosition().getY());
                this.setLayoutX(newX);
            }
        
            if (newY >= Constants.LIMIT_SCREEN_HEIGHT && newY <= Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT - this.getPixelSize()) {
                character.move(character.getPosition().getX(), newY);
                this.setLayoutY(newY);
            }
        }
    }

}
