package com.spaceinvaders.components;

import com.spaceinvaders.model.Character;
import com.spaceinvaders.model.Invasor;

import javafx.scene.paint.Color;

public abstract class InvasorComponent extends ElementArt{
    public InvasorComponent(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
        // setPixels(initialState());
    }

    private String[] states = {"Initial", "Moving", "Dead"};

    private String state = states[0];
    private Color[][] pixels;

    public String getState() {
        return this.state;
    }
    
    protected void setPixels(Color[][] pixels){
        this.pixels = pixels;
    }
    public Color[][] getPixels(){
        return this.pixels;
    }

    public void changeState(){
        if(state == "Initial") {
            pixels = movingState();
            state = "Moving";
        } else {
            state = "Initial";
            pixels = initialState();
        }
        drawArt();
    }

    public void killInvasor() {
        this.state = "Dead";
        pixels = deadState();
        drawArt();
    }

    public abstract Color[][] initialState();
    public abstract Color[][] movingState();
    public abstract Color[][] deadState();
}
