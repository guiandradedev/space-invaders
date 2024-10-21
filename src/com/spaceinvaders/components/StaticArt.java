package com.spaceinvaders.components;

import com.spaceinvaders.model.Position;

import javafx.scene.layout.Pane;

public abstract class StaticArt extends PixelArt{
    public StaticArt(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
    }

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }
}
