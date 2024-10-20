package com.spaceinvaders.components.barriers;

import com.spaceinvaders.components.StaticArt;
import com.spaceinvaders.model.Position;

import javafx.scene.layout.Pane;

public abstract class Barrier extends StaticArt{
    public Barrier(int width, int height, int pixelSize) {
        super(width, height, pixelSize);
    }

    public void print(Position position, Pane root) {
        this.setLayoutX(position.getX());
        this.setLayoutY(position.getY());

        root.getChildren().add(this);
    }
}
