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

    // public void setX(int x) {
    //     this.character.getPosition().setX
    // }
    // public void setY(int y) {
    //     this.y = y;
    // }
    public double getX(){
        return this.character.getPosition().getX();
    }
    public double getY(){
        return this.character.getPosition().getY();
    }

    public void move(int x, int y) {
        if(this.getX() + x <= Constants.SCREEN_WIDTH - Constants.LIMIT_SCREEN_WIDTH && this.getX() + x >= Constants.LIMIT_SCREEN_WIDTH) {
            character.move(this.getX() + x, 0);
            System.out.println(this.getX() + x);
            this.setLayoutX(this.character.getPosition().getX());
        } 
        if(this.getY() + y <= Constants.SCREEN_HEIGHT - Constants.LIMIT_SCREEN_HEIGHT && this.getY() + y >= Constants.LIMIT_SCREEN_HEIGHT) {
            character.move(0, this.getY() + y);
            this.setLayoutY(this.character.getPosition().getY());
        } 
    }

    public int getPixelSize() {
        return this.pixelSize;
    }

}
